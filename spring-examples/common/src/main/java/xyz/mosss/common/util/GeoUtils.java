package xyz.mosss.common.util;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoint;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.impl.PointImpl;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.lang.Math.toRadians;

/**
 * @author zhangshipeng
 * @date 2021/3/17
 */
public class GeoUtils {

    public static void main(String[] args) {
        getAll(120.200470, 30.188891, 120.082129, 30.302611);
        System.out.println("-----------------");
        getAll(120.024261, 30.216355, 117.069021, 35.556167);
        System.out.println("-----------------");
        getAll(120.024261, 30.216355, 120.193474, 30.192644);
        System.out.println("-----------------");
        getAll(116.273486, 40.040452, 116.303695, 40.006540);
        System.out.println("-----------------高德");
        getAll(116.368904, 39.923423, 116.387271, 39.922501);
        System.out.println("-----------------腾讯");
        getAll(116.273486, 40.040452, 116.303695, 40.006540);
    }

    private static void getAll(double lng1, double lat1, double lng2, double lat2) {
        double distance = getDistance(lng1, lat1, lng2, lat2);
        System.out.println("普通" + distance);
        double a = tencentCalculateLineDistance(lat1, lng1, lat2, lng2);
        System.out.println("腾讯" + a);

        int i = Double.valueOf(a).intValue();
        System.out.println(i);
        System.out.println(BigDecimal.valueOf(a).intValue());
        System.out.println(BigDecimal.valueOf(a).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
        float v = amapCalculateLineDistance(lng1, lat1, lng2, lat2);
        System.out.println("高德" + v);
        double distanceA = getDistanceA(lng1, lat1, lng2, lat2);
        System.out.println("GEO easy" + distanceA);
        SpatialContext geo = SpatialContext.GEO;
        org.locationtech.spatial4j.shape.Point point = new PointImpl(lng1, lat1, geo);
        org.locationtech.spatial4j.shape.Point point1 = new PointImpl(lng2, lat2, geo);
        double distanceB = geo.calcDistance(point, point1) * DistanceUtils.DEG_TO_KM;
        System.out.println("spatial4j" + distanceB);

    }

    public static double tencentCalculateLineDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        double a2 = (3.141592653589793d * latitude1) / 180.0d;
        double a3 = (3.141592653589793d * latitude2) / 180.0d;
        return (((double) Math.round(((Math.asin(Math.sqrt(((Math.cos(a2) * Math.cos(a3)) * Math.pow(Math.sin((a(longitude1) - a(longitude2)) / 2.0d), 2.0d)) + Math.pow(Math.sin((a2 - a3) / 2.0d), 2.0d))) * 2.0d) * 6378.137d) * 10000.0d)) / 10000.0d) * 1000.0d;
    }

    public static double a(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }


    public static float amapCalculateLineDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double d3 = longitude1 * 0.01745329251994329d;
        double d4 = latitude1 * 0.01745329251994329d;
        double d5 = longitude2 * 0.01745329251994329d;
        double d6 = latitude2 * 0.01745329251994329d;
        double sin = Math.sin(d3);
        double sin2 = Math.sin(d4);
        double cos = Math.cos(d3);
        double cos2 = Math.cos(d4);
        double sin3 = Math.sin(d5);
        double sin4 = Math.sin(d6);
        double cos3 = Math.cos(d5);
        double cos4 = Math.cos(d6);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double[] dArr2 = {cos4 * cos3, cos4 * sin3, sin4};
        return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
    }
    
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     * @param lng1 原经度
     * @param lat1 原纬度
     * @param lat2 目的纬度
     * @param lng2 目的经度
     * @return
     */
    public static double getDistance(double lng1, double lat1, double lng2,
                                     double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }


    public static double getDistanceA(double longitudeFrom, double latitudeFrom, double longitudeTo, double latitudeTo) {
        GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
        GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);

        return new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
    }


    /**
     * @param degree 代表你用几阶去拟合
     * @param Length 把10 --60 分成多少个点去拟合，越大应该越精确
     * @return
     */
    public static double[] trainPolyFit(int degree, int Length) {
        PolynomialCurveFitter polynomialCurveFitter = PolynomialCurveFitter.create(degree);
        double minLat = 10.0; //中国最低纬度
        double maxLat = 60.0; //中国最高纬度
        double interv = (maxLat - minLat) / (double) Length;
        ArrayList weightedObservedPoints = new ArrayList();
        for (int i = 0; i < Length; i++) {
            WeightedObservedPoint weightedObservedPoint = new WeightedObservedPoint(1, minLat + (double) i * interv, Math.cos(toRadians(minLat + (double) i * interv)));
            weightedObservedPoints.add(weightedObservedPoint);
        }
        return polynomialCurveFitter.fit(weightedObservedPoints);
    }

    public static double distanceSimplifyMore(double lat1, double lng1, double lat2, double lng2, double[] a) {
        //1) 计算三个参数
        double dx = lng1 - lng2; // 经度差值
        double dy = lat1 - lat2; // 纬度差值
        double b = (lat1 + lat2) / 2.0; // 平均纬度
        //2) 计算东西方向距离和南北方向距离(单位：米)，东西距离采用三阶多项式
        double Lx = (a[3] * b * b * b + a[2] * b * b + a[1] * b + a[0]) * toRadians(dx) * 6367000.0; // 东西距离
        double Ly = 6367000.0 * toRadians(dy); // 南北距离
        //3) 用平面的矩形对角距离公式计算总距离
        return Math.sqrt(Lx * Lx + Ly * Ly);
    }
}
