import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangshipeng
 * 2019-01-07
 */
public class FileDataSourceDemo {
    public static void main(String[] args) throws IOException {
        String path = FileDataSourceDemo.class.getClassLoader().getResource("live_resource.dpl").getPath();
        convert1(path);
        convert2(path);
        convert3(path);
    }


    private static void convert1(String path) throws IOException {
        String s1 = FileUtils.readFileToString(new File(path), Charset.defaultCharset());
        JSONArray objects = new JSONArray();
        if (s1 != null && !"".equals(s1)) {
            String regex = "[0-9]*\\*file\\*(http[\\s\\S]*?)[\\n\\f\\r\\t][0-9]*\\*title\\*([\\s\\S]*?)[\\n\\f\\r\\t][0-9]*\\*played\\*0";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s1);
            int count = 0;
            while (matcher.find()) {
                String matcherString1 = matcher.group(1);
                System.out.println(matcherString1.trim());
                String matcherString = matcher.group(2);
                System.out.println(matcherString.trim().replace(":-1,EXTINF:-1 ", ""));
                //
                JSONObject item = new JSONObject();
                item.put("title", matcherString);
                JSONArray objects1 = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("src", matcherString1);
                jsonObject.put("type", "application/x-mpegURL");
                objects1.add(jsonObject);
                item.put("sources", objects1);
                objects.add(item);
                count++;
            }
            System.out.println(count);
            System.out.println(objects.toJSONString());
        }
    }

    private static void convert2(String path) throws IOException {
        List<String> list = FileUtils.readLines(new File(path), Charset.defaultCharset());
        ArrayList<LiveResource> liveResources = new ArrayList<LiveResource>();
        for (int i = 0; i < list.size(); i++) {
            LiveResource liveResource1 = new LiveResource();
            if (list.get(i).contains("*file*")) {
                liveResource1.setUrl(list.get(i));
            } else {
                continue;
            }
            if (i + 1 < list.size() && list.get(i + 1).contains("*title*")) {
                liveResource1.setName(list.get(i + 1));
            } else {
                liveResource1.setName("未知");
            }
            liveResources.add(liveResource1);
        }
        System.out.println(liveResources.size());
    }

    private static void convert3(String path) throws IOException {
        List<String> list = FileUtils.readLines(new File(path), Charset.defaultCharset());
        ArrayList<LiveResource> liveResources = new ArrayList<LiveResource>();
        LiveResource liveResource = new LiveResource();
        for (String s : list) {
            if (s.contains("file")) {
                liveResource = new LiveResource();
                liveResource.setUrl(s);
            }
            if (s.contains("title")) {
                liveResource.setName(s);
                liveResources.add(liveResource);
            }

        }
        System.out.println(liveResources.size());
    }


    static class LiveResource {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public LiveResource setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
