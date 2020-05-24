package com.wang.client;

import com.wang.entity.DbDo;
import com.wang.entity.ProtocolDo;
import com.wang.utils.Crc;
import com.wang.utils.ReadProperties;
import com.wang.utils.SqlConn;
import com.wang.utils.StringToAscii;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.Map;
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
     * 数据表
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
                } catch (IOException ex) {
                    Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    /**
     * 创建一个 IOJFrame
     */
    public UdpClientFrame() throws IOException {
        initComponents();
    }

    /**
     * 组件的初始化的方法
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
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
        jLabel5.setText("时间段查询区");
        jTextField3.setText("2020-01-01");
        jTextField4.setText("2020-02-03");

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
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // 读取报文头格式
        ReadProperties readProperties = new ReadProperties();
        ProtocolDo protocolDo = readProperties.readProtocol();
        Map<String,String> codeMap = readProperties.readCode();

        // 拿到前台的数据表
        String selectItem = (String) jcbb.getSelectedItem();

        // 即将发送的数据段报
        msg = jTextArea2.getText();
        String sendData = "ST="+protocolDo.getST()+";"+"CN=2011"+";"+"PW="+protocolDo.getPW()+";"+"MN="+protocolDo.getID()+";"+"CP=&&"+ msg;

        // 冗余码
        Crc crc = new Crc();
        String makeCrc = crc.Make_CRC(sendData.getBytes());

        // 读取命令编码
        String Code = codeMap.get(selectItem);

        // 数据段的ascii数
        StringToAscii stringToAscii = new StringToAscii();
        String strToAsc = stringToAscii.StrToAsc(sendData);

        String sendMsg = "[CN=" + Code + "]##"+ strToAsc + sendData + makeCrc;
        jTextArea1.append("已发送 : "+ sendMsg +"\n");
        jTextArea2.setText(null);
        try {
            // 发送报文数据
            ec.send(sendMsg);
        } catch (Exception ex) {
            Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        DatabaseMetaData md = conn.getMetaData();
        ResultSet rs2 = md.getTables(null, null,"%", new String[] {"TABLE"});

        // 拿到前台的数据表
        String selectItem = (String) jcbb.getSelectedItem();
        System.out.println("拿到里面的表："+selectItem);

        String table = selectItem;

        jcbb.removeAllItems();
        while (rs2.next()) {
            System.out.println("表名: "+rs2.getString("TABLE_NAME"));
            jcbb.addItem(rs2.getString("TABLE_NAME"));
        }

        // 时间区域查询数据库数据
        // 开始的时间
        String text3 = jTextField3.getText();
        String text4 = jTextField4.getText();



        if(null == selectItem || selectItem.equals("")){
            System.out.println("开始进行查表初始化！");
        }else if(selectItem.equals("historydata1")){
            try {
                String sql = " SELECT * FROM historydata1 WHERE dt BETWEEN ? AND ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,text3);
                pstmt.setString(2,text4);
                ResultSet rs= pstmt.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("id");
                    Timestamp timestamp = rs.getTimestamp("dt");
                    double FLOWD = rs.getDouble("FLOWD");
                    double FLOWDMAX = rs.getDouble("FLOWDMAX");
                    double FLOWDMIN = rs.getDouble("FLOWDMIN");
                    double FLOWDAVG  = rs.getDouble("FLOWDAVG");
                    double DUSTMIN   = rs.getDouble("DUSTMIN");
                    double DUSTS     = rs.getDouble("DUSTS");
                    double DUSTMAX   = rs.getDouble("DUSTMAX");
                    double ZSDUSTMIN = rs.getDouble("ZSDUSTMIN");
                    double ZSDUSTAVG = rs.getDouble("ZSDUSTAVG");
                    double ZSDUSTMAX = rs.getDouble("ZSDUSTMAX");
                    double DUST      = rs.getDouble("DUST");
                    double SO2MIN    = rs.getDouble("SO2MIN");
                    double SO2AVG    = rs.getDouble("SO2AVG");
                    double SO2MAX    = rs.getDouble("SO2MAX");
                    double ZSSO2MIN  = rs.getDouble("ZSSO2MIN");
                    double ZSSO2AVG  = rs.getDouble("ZSSO2AVG");
                    double ZSSO2MAX  = rs.getDouble("ZSSO2MAX");
                    double SO2       = rs.getDouble("SO2");
                    double NOXMIN    = rs.getDouble("NOXMIN");
                    double NOXAVG    = rs.getDouble("NOXAVG");
                    double NOXMAX    = rs.getDouble("NOXMAX");
                    double ZSNOXMIN  = rs.getDouble("ZSNOXMIN");
                    double ZSNOXAVG  = rs.getDouble("ZSNOXAVG");
                    double ZSNOXMAX  = rs.getDouble("ZSNOXMAX");
                    double NOX       = rs.getDouble("NOX");
                    double O2MIN     = rs.getDouble("O2MIN");
                    double O2AVG     = rs.getDouble("O2AVG");
                    double O2MAX     = rs.getDouble("O2MAX");
                    double FVMIN     = rs.getDouble("FVMIN");
                    double FVAVG     = rs.getDouble("FVAVG");
                    double FVMAX     = rs.getDouble("FVMAX");
                    double TMIN      = rs.getDouble("TMIN");
                    double TS        = rs.getDouble("TS");
                    double TMAX      = rs.getDouble("TMAX");
                    double HMMIN     = rs.getDouble("HMMIN");
                    double HMS       = rs.getDouble("HMS");
                    double HMMAX     = rs.getDouble("HMMAX");
                    double MJMIN     = rs.getDouble("MJMIN");
                    double MJAVG     = rs.getDouble("MJAVG");
                    double MJMAX     = rs.getDouble("MJMAX");
                    double PMIN      = rs.getDouble("PMIN");
                    double PS        = rs.getDouble("PS");
                    double PMAX      = rs.getDouble("PMAX");
                    double NH3MIN    = rs.getDouble("NH3MIN");
                    double NH3AVG    = rs.getDouble("NH3AVG");
                    double NH3MAX    = rs.getDouble("NH3MAX");
                    double ZSHN3MIN  = rs.getDouble("ZSHN3MIN");
                    double ZSNH3AVG  = rs.getDouble("ZSNH3AVG");
                    double ZSNH3MAX  = rs.getDouble("ZSNH3MAX");
                    double NH3       = rs.getDouble("NH3");
                    msg = "[" + String.valueOf(timestamp) +"],"+ String.valueOf(id) +","+ "FLOWD="+ String.valueOf(FLOWD) +","+ "FLOWDMAX="+ String.valueOf(FLOWDMAX)+","+ "FLOWDMIN="+ String.valueOf(FLOWDMIN)+ ","+
                           "FLOWDAVG="+ String.valueOf(FLOWDAVG) +","+ "DUSTMIN="+ String.valueOf(DUSTMIN)+","+ "DUSTS="+ String.valueOf(DUSTS)+ ","+
                           "DUSTMAX="+ String.valueOf(DUSTMAX) +","+ "ZSDUSTMIN="+ String.valueOf(ZSDUSTMIN)+","+ "ZSDUSTAVG="+ String.valueOf(ZSDUSTAVG)+ ","+
                           "ZSDUSTMAX="+ String.valueOf(ZSDUSTMAX) +","+ "DUST="+ String.valueOf(DUST)+","+ "SO2MIN="+ String.valueOf(SO2MIN)+ ","+
                           "SO2AVG="+ String.valueOf(SO2AVG) +","+ "SO2MAX="+ String.valueOf(SO2MAX)+","+ "ZSSO2MIN="+ String.valueOf(ZSSO2MIN)+ ","+
                           "ZSSO2AVG="+ String.valueOf(ZSSO2AVG) +","+ "ZSSO2MAX="+ String.valueOf(ZSSO2MAX)+","+ "SO2="+String.valueOf(SO2)+ ","+
                           "NOXMIN="+ String.valueOf(NOXMIN) +","+ "NOXAVG="+ String.valueOf(NOXAVG)+","+ "NOXMAX="+ String.valueOf(NOXMAX)+ ","+
                           "ZSNOXMIN="+ String.valueOf(ZSNOXMIN) +","+ "ZSNOXAVG="+ String.valueOf(ZSNOXAVG)+","+ "ZSNOXMAX="+ String.valueOf(ZSNOXMAX)+ ","+
                           "NOX="+ String.valueOf(NOX) +","+ String.valueOf(O2MIN)+","+ String.valueOf(O2AVG)+ ","+
                           "O2MAX="+ String.valueOf(O2MAX) +","+ "FVMIN="+ String.valueOf(FVMIN)+","+ "FVAVG="+ String.valueOf(FVAVG)+ ","+
                           "FVMAX="+ String.valueOf(FVMAX) +","+ "TMIN="+ String.valueOf(TMIN)+","+ "TS="+ String.valueOf(TS)+ ","+
                           "TMAX="+ String.valueOf(TMAX) +","+ "HMMIN="+ String.valueOf(HMMIN)+","+ "HMS="+ String.valueOf(HMS)+ ","+
                           "HMMAX="+ String.valueOf(HMMAX) +","+ "MJMIN="+ String.valueOf(MJMIN)+","+ "MJAVG="+ String.valueOf(MJAVG)+ ","+
                           "MJMAX="+ String.valueOf(MJMAX) +","+ "PMIN="+ String.valueOf(PMIN)+","+ "PS="+ String.valueOf(PS)+ ","+
                           "PMAX="+ String.valueOf(PMAX) +","+ "NH3MIN="+ String.valueOf(NH3MIN)+","+ "NH3AVG="+ String.valueOf(NH3AVG)+ ","+
                           "NH3MAX="+ String.valueOf(NH3MAX) +","+ "ZSHN3MIN="+ String.valueOf(ZSHN3MIN)+","+ "ZSNH3AVG="+ String.valueOf(ZSNH3AVG)+ ","+
                           "ZSNH3MAX="+ String.valueOf(ZSNH3MAX) +","+ "NH3="+ String.valueOf(NH3);
                    jTextArea1.append(msg + "\n");
                }
                jTextArea2.setText(null);

            } catch (Exception ex) {
                Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                // 关闭数据库连接
                conn.close();
            }
        }else if(selectItem.equals("MinutesTable")){
            try {
                String sql = " SELECT * FROM MinutesTable WHERE dt BETWEEN ? AND ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,text3);
                pstmt.setString(2,text4);
                ResultSet rs= pstmt.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("id");
                    Timestamp timestamp = rs.getTimestamp("dt");
                    double VER1 = rs.getDouble("VER1");
                    double VER10 = rs.getDouble("VER10");
                    double VER2 = rs.getDouble("VER2");
                    double VER3 = rs.getDouble("VER3");
                    double VER4 = rs.getDouble("VER4");
                    double VER5 = rs.getDouble("VER5");
                    double VER6 = rs.getDouble("VER6");
                    double VER7 = rs.getDouble("VER7");
                    double VER8 = rs.getDouble("VER8");
                    double VER9 = rs.getDouble("VER9");

                    msg =   "[" + String.valueOf(timestamp) +"],"+ String.valueOf(id) +","+
                            "VER1="+ String.valueOf(VER1) +","+ "VER10="+ String.valueOf(VER10)+","+ "VER2="+String.valueOf(VER2)+ ","+
                            "VER3="+ String.valueOf(VER3) +","+ "VER4="+ String.valueOf(VER4)+","+ "VER5="+ String.valueOf(VER5)+ ","+
                            "VER6="+ String.valueOf(VER6) +","+ "VER7="+ String.valueOf(VER7)+","+ "VER8="+ String.valueOf(VER8)+ ","+
                            "VER9="+ String.valueOf(VER9);
                    jTextArea1.append(msg + "\n");
                }
                jTextArea2.setText(null);

            } catch (Exception ex) {
                Logger.getLogger(UdpClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                // 关闭数据库连接
                conn.close();
            }
        }else{
            System.out.println("还没有该表的查表逻辑！");
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
