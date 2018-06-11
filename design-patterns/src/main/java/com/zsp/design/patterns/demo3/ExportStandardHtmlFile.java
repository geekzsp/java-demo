package com.zsp.design.patterns.demo3;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ExportStandardHtmlFile implements ExportFile {
    /**
     * 文件导出
     *
     * @param data
     */
    @Override
    public boolean exprot(String data) {
        System.out.println("导出标准版HTML文件");
        return true;
    }
}
