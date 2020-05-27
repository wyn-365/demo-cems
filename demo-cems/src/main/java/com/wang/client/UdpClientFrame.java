package com.wang.client;

import com.wang.entity.DbDo;
import com.wang.entity.ProtocolDo;
import com.wang.utils.Crc;
import com.wang.utils.ReadProperties;
import com.wang.utils.SqlConn;
import com.wang.utils.StringToAscii;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 王一宁
 * @date 2020/4/29 15:04
 */
public class UdpClientFrame extends javax.swing.JFrame {
    /**
     * 组件常量
     */
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    /**
     * 时间输入区域
     */
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;

    /**
     * 数据表下拉列表
     */
    private javax.swing.JComboBox<String> jcbb;


    /**
     * UdpClient客户端、消息体
     */
    private UdpClient ec;
    private String msg;

    /**
     * 主方法，方法入口
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UdpClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UdpClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UdpClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UdpClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /**
         * 启动线程队列
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UdpClientFrame ioj =new UdpClientFrame();
                    ioj.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    /**
     * 创建一个 IOJFrame
     */
    public UdpClientFrame() throws Exception {
        initComponents();
    }

    /**
     * 组件的初始化的方法
     */
    @SuppressWarnings("unchecked")
    private void initComponents() throws Exception {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jcbb = new javax.swing.JComboBox<String>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("IP地址");
        jLabel2.setText("端口");
        jLabel5.setText("时间");
        jTextField3.setText("2020-01-01");
        jTextField4.setText("2020-02-03");

        ReadProperties readProperties = new ReadProperties();
        Map<String, String> tableCodeMap = readProperties.readCode();
        Set<String> set = tableCodeMap.keySet();
        for (String key: set){
            System.out.println(key);
            jcbb.addItem(key);
        }




        /**
         * 文本域1的监听事件
         */
        jTextField1.setText("127.0.0.1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });



        /**
         * 文本域2的监听事件
         */
        jTextField2.setText("6666");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("测试连接");
        jButton2.setBackground(Color.GREEN);

        /**
         * 文本域3的监听事件
         */
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        /**
         * 文本域4的监听事件
         */
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });


        /**
         * 按钮2的监听事件
         */
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setSelectedTextColor(Color.GREEN);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addCaretListener(new javax.swing.event.CaretListener() {
            @Override
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea1CaretUpdate(evt);
            }
        });
        jTextArea1.addAncestorListener(new javax.swing.event.AncestorListener() {
            @Override
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            @Override
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextArea1AncestorAdded(evt);
            }
            @Override
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTextArea1);
        jLabel3.setText("信息显示区");
        jLabel4.setText("信息录入区");
        jScrollPane2.setAutoscrolls(true);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea2);
        jButton3.setText("数据上传");
        jButton3.setBackground(Color.green);

        /**
         * 按钮3的监听事件
         */
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("查询数据");
        jButton4.setBackground(Color.orange);

        /**
         * 按钮4的监听事件
         */
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        /**
         * 窗体的整体布局
         */
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)

                        .addComponent(jLabel2)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))

                        .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)

                        .addComponent(jLabel3)

                        .addComponent(jLabel4)
                                .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbb)
                        .addComponent(jButton4,javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton3,javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addGap(18, 18, 18)

                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)

                                .addGap(8, 8, 8)

                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbb)
                                .addComponent(jButton4)
                                .addComponent(jButton3)
                        )
                        .addGap(22, 22, 22)));
        pack();
    }

    /**
     * 数据发送的方法
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        // 读取报文头格式
        ReadProperties readProperties = new ReadProperties();
        ProtocolDo protocolDo = readProperties.readProtocol();
        Map<String,String> codeMap = readProperties.readCode();

        // 拿到前台的数据表
        String selectItem = (String) jcbb.getSelectedItem();

        // 根据数据表 读取命令编码
        String Code = codeMap.get(selectItem);

        System.out.println("数据表编码是--------------：" + Code);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String formatTime = dateTime.format(pattern);

        // 即将发送的数据段报
        msg = jTextArea2.getText();
        String sendData = "ST="+protocolDo.getST()+";"+ "CN="+ Code +";"+"PW="+protocolDo.getPW()+";"+"MN="+protocolDo.getID()+";"+"CP=&&DateTime=" + msg;

        // 冗余码
        Crc crc = new Crc();
        String makeCrc = crc.Make_CRC(sendData.getBytes());

        // 数据段的ascii数
        StringToAscii stringToAscii = new StringToAscii();
        String strToAsc = stringToAscii.StrToAsc(sendData);

        // 服务器收到的数据报文
        String sendMsg = "##"+ strToAsc + sendData + "&&" +makeCrc;

        jTextArea1.append("[" +formatTime+ "]"+"[发送]"+ "["+selectItem+"]"+ "[CN=" + Code + "]" + sendMsg +"\n");

        jTextArea2.setText(null);
        try {
            // 发送报文数据
            ec.send(sendMsg);
        } catch (Exception ex) {
            Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        }
    }

    /**
     * 查询数据库数据的方法
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {

        // 获取数据库链接
        ReadProperties readProperties = new ReadProperties();
        DbDo dbDo = readProperties.readDB();
        Connection conn= SqlConn.getConn(dbDo.getDriver(), dbDo.getURL(), dbDo.getUSER(), dbDo.getPASSWORD());
        System.out.println("SqlServer连接成功与否："+ conn);

        // 拿到前台的数据表
        String selectItem = (String) jcbb.getSelectedItem();
        System.out.println("拿到里面的表："+selectItem);

        String table = selectItem;

        // 时间区域查询数据库数据
        String text3 = jTextField3.getText();
        String text4 = jTextField4.getText();

        // 读取数据表字段
        Map<String, String> tableMap = readProperties.readTable();

        if(null == selectItem || selectItem.equals("")){
            System.out.println("开始进行查表初始化！");
        }else {
            try {
                String sql = " SELECT * FROM "+table+" WHERE 时间 BETWEEN ? AND ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,text3);
                pstmt.setString(2,text4);
                ResultSet rs= pstmt.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("ID");
                    Timestamp timestamp = rs.getTimestamp("时间");
                    double FLOWD = rs.getDouble(tableMap.get("B02-Cou"));
                    double FLOWDMAX = rs.getDouble(tableMap.get("B02-Max"));
                    double FLOWDMIN = rs.getDouble(tableMap.get("B02-Min"));
                    double FLOWDAVG  = rs.getDouble(tableMap.get("B02-Avg"));
                    double DUSTMIN   = rs.getDouble(tableMap.get("01-Min"));
                    double DUSTS     = rs.getDouble(tableMap.get("01-Avg"));
                    double DUSTMAX   = rs.getDouble(tableMap.get("01-Max"));
                    double ZSDUSTMIN = rs.getDouble(tableMap.get("01-ZsMin"));
                    double ZSDUSTAVG = rs.getDouble(tableMap.get("01-ZsAvg"));
                    double ZSDUSTMAX = rs.getDouble(tableMap.get("01-ZsMax"));
                    double DUST      = rs.getDouble(tableMap.get("01-Cou"));
                    double SO2MIN    = rs.getDouble(tableMap.get("02-Min"));
                    double SO2AVG    = rs.getDouble(tableMap.get("02-Avg"));
                    double SO2MAX    = rs.getDouble(tableMap.get("02-Max"));
                    double ZSSO2MIN  = rs.getDouble(tableMap.get("02-ZsMin"));
                    double ZSSO2AVG  = rs.getDouble(tableMap.get("02-ZsAvg"));
                    double ZSSO2MAX  = rs.getDouble(tableMap.get("02-ZsMax"));
                    double SO2       = rs.getDouble(tableMap.get("02-Cou"));
                    double NOXMIN    = rs.getDouble(tableMap.get("03-Min"));
                    double NOXAVG    = rs.getDouble(tableMap.get("03-Avg"));
                    double NOXMAX    = rs.getDouble(tableMap.get("03-Max"));
                    double ZSNOXMIN  = rs.getDouble(tableMap.get("03-ZsMin"));
                    double ZSNOXAVG  = rs.getDouble(tableMap.get("03-ZsAvg"));
                    double ZSNOXMAX  = rs.getDouble(tableMap.get("03-ZsMax"));
                    double NOX       = rs.getDouble(tableMap.get("03-Cou"));
                    double O2MIN     = rs.getDouble(tableMap.get("S01-Min"));
                    double O2AVG     = rs.getDouble(tableMap.get("S01-Avg"));
                    double O2MAX     = rs.getDouble(tableMap.get("S01-Max"));
                    double FVMIN     = rs.getDouble(tableMap.get("S02-Min"));
                    double FVAVG     = rs.getDouble(tableMap.get("S02-Avg"));
                    double FVMAX     = rs.getDouble(tableMap.get("S02-Max"));
                    double TMIN      = rs.getDouble(tableMap.get("S03-Min"));
                    double T        = rs.getDouble(tableMap.get("S03-Avg"));
                    double TMAX      = rs.getDouble(tableMap.get("S03-Max"));
                    double HMMIN     = rs.getDouble(tableMap.get("S05-Min"));
                    double HMS       = rs.getDouble(tableMap.get("S05-Avg"));
                    double HMMAX     = rs.getDouble(tableMap.get("S05-Max"));
                    double MJ     = rs.getDouble(tableMap.get("S07-Avg"));
                    double PMIN      = rs.getDouble(tableMap.get("S08-Min"));
                    double P        = rs.getDouble(tableMap.get("S08-Avg"));
                    double PMAX      = rs.getDouble(tableMap.get("S08-Max"));
                    double NH3MIN    = rs.getDouble(tableMap.get("10-Min"));
                    double NH3AVG    = rs.getDouble(tableMap.get("10-Avg"));
                    double NH3MAX    = rs.getDouble(tableMap.get("10-Max"));
                    double ZSHN3MIN  = rs.getDouble(tableMap.get("10-ZsMin"));
                    double ZSNH3AVG  = rs.getDouble(tableMap.get("10-ZsAvg"));
                    double ZSNH3MAX  = rs.getDouble(tableMap.get("10-ZsMax"));
                    double NH3       = rs.getDouble(tableMap.get("10-Cou"));

                    LocalDateTime dateTime = timestamp.toLocalDateTime();
                    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyMMddhhmmss");
                    String format = dateTime.format(pattern);


                    msg =  String.valueOf(id) +"->"+ format +","+ "B02-Cou="+ String.valueOf(FLOWD) +","+ "B02-Max="+ String.valueOf(FLOWDMAX)+","+ "B02-Min="+ String.valueOf(FLOWDMIN)+ ","+
                           "B02-Avg="+ String.valueOf(FLOWDAVG) +","+ "01-Min="+ String.valueOf(DUSTMIN)+","+ "01-Avg="+ String.valueOf(DUSTS)+ ","+
                           "01-Max="+ String.valueOf(DUSTMAX) +","+ "01-ZsMin="+ String.valueOf(ZSDUSTMIN)+","+ "01-ZsAvg="+ String.valueOf(ZSDUSTAVG)+ ","+
                           "01-ZsMax="+ String.valueOf(ZSDUSTMAX) +","+ "01-Cou="+ String.valueOf(DUST)+","+ "02-Min="+ String.valueOf(SO2MIN)+ ","+
                           "02-Avg="+ String.valueOf(SO2AVG) +","+ "02-Max="+ String.valueOf(SO2MAX)+","+ "02-ZsMin="+ String.valueOf(ZSSO2MIN)+ ","+
                           "02-ZsAvg="+ String.valueOf(ZSSO2AVG) +","+ "02-ZsMax="+ String.valueOf(ZSSO2MAX)+","+ "02-Cou="+String.valueOf(SO2)+ ","+
                           "03-Min="+ String.valueOf(NOXMIN) +","+ "03-Avg="+ String.valueOf(NOXAVG)+","+ "03-Max="+ String.valueOf(NOXMAX)+ ","+
                           "03-ZsMin="+ String.valueOf(ZSNOXMIN) +","+ "03-ZsAvg="+ String.valueOf(ZSNOXAVG)+","+ "03-ZsMax="+ String.valueOf(ZSNOXMAX)+ ","+
                           "03-Cou="+ String.valueOf(NOX) +","+ "S01-Min="+ String.valueOf(O2MIN)+","+ "S01-Avg="+ String.valueOf(O2AVG)+ ","+
                           "S01-Max="+ String.valueOf(O2MAX) +","+ "S02-Min="+ String.valueOf(FVMIN)+","+ "S02-Avg="+ String.valueOf(FVAVG)+ ","+
                           "S02-Max="+ String.valueOf(FVMAX) +","+ "S03-Min="+ String.valueOf(TMIN)+","+ "S03-Avg="+ String.valueOf(T)+ ","+
                           "S03-Max="+ String.valueOf(TMAX) +","+ "S05-Min="+ String.valueOf(HMMIN)+","+ "S05-Avg="+ String.valueOf(HMS)+ ","+
                           "S05-Max="+ String.valueOf(HMMAX) +","+ "S07-Avg="+ String.valueOf(MJ)+ ","+
                           "S08-Min="+ String.valueOf(PMIN)+","+ "S08-Avg="+ String.valueOf(P)+ ","+
                           "S08-Max="+ String.valueOf(PMAX) +","+ "10-Min="+ String.valueOf(NH3MIN)+","+ "10-Avg="+ String.valueOf(NH3AVG)+ ","+
                           "10-Max="+ String.valueOf(NH3MAX) +","+ "10-ZsMin="+ String.valueOf(ZSHN3MIN)+","+ "10-ZsAvg="+ String.valueOf(ZSNH3AVG)+ ","+
                           "10-ZsMax="+ String.valueOf(ZSNH3MAX) +","+ "10-Cou="+ String.valueOf(NH3);
                    jTextArea1.append(msg + "\n");
                }
                jTextArea2.setText(null);

            } catch (Exception ex) {
                Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                // 关闭数据库连接
                conn.close();
            }
        }


        System.out.println("开始时间:"+text3);
        System.out.println("结束时间:"+text4);
    }

    /**
     * 连接UDP服务器的方法
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //连接按钮
        String ip;
        String port;
        if(!jTextField1.getText().equals("")){
            ip=jTextField1.getText();
            port=jTextField2.getText();
        }
        else{
            ip = "127.0.0.1";
            port = "6666";
        }
        try {
            ec = new UdpClient(ip,port);
            jTextArea1.append("UDP正在创建...\r\n");
            Thread receiver = new Thread(){
                @Override
                public void run(){
                    String msg = null;
                    while(true){
                        try{
                            msg = ec.receive();
                        } catch(Exception ex){
                            jTextArea1.append("套接字异常关闭!"+"\n");
                        }
                        if(msg!=null){
                            jTextArea1.append(msg+"\n");
                        }
                        else{
                            jTextArea1.append("你的对话已关闭！"+"\n");
                            break;
                        }
                    }
                }};
            receiver.start();
            jTextArea1.append("UDP创建成功...\r\n");
        } catch (IOException ex) {
            jTextArea1.append("UDP创建失败...\r\n");
        }
    }


    private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextArea1AncestorAdded(javax.swing.event.AncestorEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
