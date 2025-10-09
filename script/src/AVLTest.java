class Student {

    private String code;
    private String name;
    private double gpa;

    public Student(String code, String name, double gpa) {
        this.code = code;
        this.name = name;
        this.gpa = gpa;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return code + "-" + name + "-" + gpa + " ";
    }
}

class Node {

    private Student data;
    private Node left, right;
    private int height;

    public Node(Student data) {
        this.data = data;
        this.height = 1;
    }

    public Student getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class AVLTree {

    private Node root;
    private String inorder;

    private int height(Node n) {
        return (n == null) ? 0 : n.getHeight();
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.getLeft()) - height(n.getRight());
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = (x != null) ? x.getRight() : null;

        // Perform rotation
       

        // Update heights
        

        // Return new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = (y != null) ? y.getLeft() : null;

        // Perform rotation
        

        // Update height
        

        // Return New Root
        return y;
    }

    private Node insert(Node node, Student data) {
        if (node == null) {
            return new Node(data);
        }

        if (data.getCode().compareTo(node.getData().getCode()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data.getCode().compareTo(node.getData().getCode()) > 0) {
            node.setRight(insert(node.getRight(), data));
        } else {
            return node;
        }

        // Update height
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);
        
        // Left Left <
        if (balance > 1 && data.getCode().compareTo(node.getLeft().getData().getCode()) < 0) {
            return rightRotate(node);
        }

        // Right Right >
        

        // Left Right >
        

        // Right Left <
       

        return node;
    }

    public void insert(Student data) {
        root = insert(root, data);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.getLeft());
            inorder += node.getData().toString();
            inorderRec(node.getRight());
        }
    }

    public void inorder() {
        inorder = "";
        inorderRec(root);
    }

    public String getInorder() {
        return inorder;
    }
}

public class AVLTest extends javax.swing.JFrame {


    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AVLTest.class.getName());

    public AVLTest() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("genStudent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("createAVL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Inorder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(19, 19, 19)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }                      

    // genStudent botton
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    // createAVL botton
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }                                        

    // Inorder
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new AVLTest().setVisible(true));
    }

                       
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
                     
}
