package com.samit;

public class JavaDet {

    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .forEach(p -> {
                    if(p.command().isPresent()){
                        String cmd = p.command().get().toLowerCase();

                        if(cmd.contains("zoom") ||
                                cmd.contains("teams") ||
                                cmd.contains("obs") ||
                                cmd.contains("anydesk")){
                            System.out.println(cmd);
                            System.out.println("Yes Active");
                        }else{
                            System.out.println("Not Active");
                        }
                    }
                });
    }
}
