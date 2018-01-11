package com.orhanobut.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Kale
 * @date 2016/12/8
 */

public abstract class PrintStyle {

    private LogPrinter printer;

    public void setPrinter(LogPrinter printer) {
        this.printer = printer;
    }

    @Nullable
    protected abstract String beforePrint();

    protected abstract String printStackAndThread();

    @NonNull
    protected abstract String printLog(String message, int line, int wholeLineCount);

    @Nullable
    protected abstract String afterPrint();

    public LogBuilder getSettings() {
        return printer.getLogBuilder();
    }

    public LogPrinter getPrinter() {
        return printer;
    }
}
