package com.zsp.design.patterns.demo3;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ExportFinancialHtmlFile implements ExportFile {
    /**
     * 文件导出
     *
     * @param data
     */
    @Override
    public boolean exprot(String data) {
        System.out.println("导出财务版HTML文件");
        return true;
    }
}
