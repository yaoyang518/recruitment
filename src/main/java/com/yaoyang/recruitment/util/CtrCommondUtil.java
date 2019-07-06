package com.yaoyang.recruitment.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <p>Title:CtrCommond </p>
 * <p>Description: 链接服务器的工具类</p>
 *
 * @author yaoyang
 * @date Jul 24, 2017
 */
public class CtrCommondUtil {


    /**
     * 获取服务器链接
     *
     * @param hostName
     * @param userName
     * @param sshPort
     * @param passWord
     * @return
     */
    public static Connection getConn(String hostName, String userName, int sshPort, String passWord) {
        try {
            Connection conn = new Connection(hostName, sshPort);
            //连接到主机
            conn.connect();
            //使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(userName, passWord);
            if (!isconn) {
                System.out.println("用户名称或者是密码不正确");
            } else {
                return conn;
            }
        } catch (IOException e) {
            System.out.println("获取服务器链接出现异常：" + e.toString());
            return null;
        }
        return null;
    }

    /**
     * 远程执行命令
     *
     * @param conn
     * @param cmd
     * @return
     */
    public static String doCommond(Connection conn, String cmd) {
        String result = "";
        try {
            if (conn == null) {
                System.out.println("请先链接服务器");
            } else {
                Session sess = conn.openSession();
                sess.execCommand(cmd);
                InputStream stdout = new StreamGobbler(sess.getStdout());
                BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
                while (true) {
                    String line = stdoutReader.readLine();
                    if (line == null){
                        break;}
                    result += line + "</br>";
                }
                //连接的Session和Connection对象都需要关闭 
                stdoutReader.close();
                sess.close();
            }
        } catch (IOException e) {
            System.out.println("执行linux命令错误：" + e.toString());
        }finally {
            conn.close();
        }

        if (!StringUtils.isEmpty(result)) {
            if (cmd.contains("DEV") || cmd.contains("iostat")) {
                if (result.contains("</br></br>")) {
                    result = result.substring(result.lastIndexOf("</br></br>") + 10);
                }
            }
            if (cmd.contains("mpstat")) {
                if (result.contains("</br></br>")) {
                    result = result.substring(result.lastIndexOf("</br></br>") + 10);
                    int s = result.indexOf("</br>") + 5;
                    s = result.indexOf("</br>", s);
                    result = result.substring(0, s);
                }
            }
        }
        return result;
    }

}
