package com.zsp.design.patterns.demo1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class MainBoardFactory {
    private static final int INTEL = 1;
    private static final int AMD = 2;

    public static MainBoard createMainBoard(int type) {
        MainBoard mainBoard = null;
        if (type == INTEL) {
            mainBoard = new IntelMainBoard(755);
        } else if (type == AMD) {
            mainBoard = new AmdMainBoard(938);
        }
        return mainBoard;
    }
}
