package com.zsp.design.patterns.demo3;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ExportPdfFactory implements  ExportFactory {
    @Override
    public ExportFile factory(String type) {

        if("standard".equals(type)){

            return new ExportStandardPdfFile();

        }else if("financial".equals(type)){

            return new ExportFinancialPdfFile();

        }else{
            throw new RuntimeException("没有找到对象");
        }
    }
}
