package com.orhanobut.logger;

import android.support.annotation.NonNull;

/**
 * @author Kale
 * @date 2016/12/8
 */

public class LogPrintStyle extends PrintStyle {

    private static final String PREFIX_BORDER = "│ ";
    @Override
    public String beforePrint() {
        return "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    }

    /**
     * ==> onCreate(MainActivity.java:827) Thread:main
     */
    @Override
    protected   String printStackAndThread() {
        if (!getSettings().showMethodLink) {
            return "";
        }



       /* if (sb.length() < 0) {
            sb = new StringBuilder();
        } else {
            sb.setLength(0);

        }*/
         StringBuilder  sb = new StringBuilder(200);
       /* sb.append("\n");
        sb.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
        sb.append("\n");*/
           sb.append(PREFIX_BORDER);

        if (getSettings().showThreadInfo) {
            sb.append(" ────> Thread: ").append(Thread.currentThread().getName()).append(","); // Thread:main
        }

           //打印方法栈信息,打印三层
        int index = Logger.STACK_OFFSET + getSettings().methodOffset ;
        if (getPrinter().isCustomTag()) {
            index -= 2;
        }
        if(Logger.isTagJson){
            index++;
        }
        StackTraceElement[]  elements= Thread.currentThread().getStackTrace();

        if(index > elements.length-1){
            index = elements.length-1;
        }



         StackTraceElement stack = elements[index];
       String info = String.format(" %s(%s:%s),", stack.getMethodName(), stack.getFileName(), stack.getLineNumber());
       sb.append(info);

        //上一个栈
        if(index +1 <= elements.length - 1){
            StackTraceElement stack0 = elements[index+1];
            String info0 = String.format("pre: %s(%s:%s),", stack0.getMethodName(), stack0.getFileName(), stack0.getLineNumber());
            sb.append(info0);
        }

       //下一个栈
        StackTraceElement stack2 = elements[index-1];
        String info2 = String.format("next: %s(%s:%s)", stack2.getMethodName(), stack2.getFileName(), stack2.getLineNumber());
        sb.append(info2);

       return sb.toString();
    }

    @NonNull
    @Override
    public String printLog(String message, int line, int wholeCount) {
       /* if (line == wholeCount - 1) {
            // last line
            return "│ " + message + getTail();
        } else {
            return PREFIX_BORDER + message;
        }*/

        return " " + message;
    }

    @Override
    public String afterPrint() {
        return "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    }



}
