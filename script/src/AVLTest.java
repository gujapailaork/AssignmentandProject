import java.util.Random;

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
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        // Return new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = (y != null) ? y.getLeft() : null;

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // Update height
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

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
        if (balance < -1 && data.getCode().compareTo(node.getRight().getData().getCode()) > 0) {
            return leftRotate(node);
        }

        // Left Right >
        if (balance > 1 && data.getCode().compareTo(node.getLeft().getData().getCode()) > 0) {
            return rightRotate(node);
        }

        // Right Left <
        if (balance < -1 && data.getCode().compareTo(node.getRight().getData().getCode()) < 0) {
            return leftRotate(node);
        }

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
    public static Student[] data;
    public static AVLTree avl;

    public static Student genStudent() {
        Random r = new Random();
        String code = "" + r.nextInt(90) + 10;
        String text1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text2 = "abcdefghijklmnopqrstuvwxyz";
        String name = "" + text1.charAt(r.nextInt(text1.length() - 1));
        int n = r.nextInt(3) + 3;
        for (int i = 0; i < n; i++) {
            name += text2.charAt(r.nextInt(text2.length() - 1));
        }
        name += " ";
        name += text1.charAt(r.nextInt(text1.length() - 1));
        n = r.nextInt(3) + 3;
        for (int i = 0; i < n; i++) {
            name += text2.charAt(r.nextInt(text2.length() - 1));
        }
        name += " ";

        double gpa = r.nextInt(4) + r.nextInt(100) / 10;
        return new Student(code, name, gpa);
    }

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AVLTest.class.getName());

    public AVLTest() {
        initComponents();
        AVLTree avl = new AVLTree();
        for (int i = 0; i < 5; i++) {
            Student x = genStudent();
            System.out.println(x.toString());
            avl.insert(x);
        }
        System.out.println("Inorder Traversal");
        avl.inorder();

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
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField3,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 606,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jTextField2))))
                                .addGap(30, 30, 30)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(19, 19, 19)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(119, Short.MAX_VALUE)));

        pack();
    }

    // genStudent botton
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int n = Integer.parseInt(jTextField1.getText());
        if (n == 0) {
            return;
        }

        data = new Student[n];
        String students = "";
        for (int i = 0; i < n; i++) {
            Student x = genStudent();
            data[i] = x;
            students += x.toString();
        }

        jTextField2.setText(students);
    }

    // createAVL botton
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (data == null) {
            return;
        }
        avl = new AVLTree();
        for (Student s : data) {
            avl.insert(s);
        }
    }

    // Inorder botton
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (avl == null) {
            return;
        }
        avl.inorder();
        jTextField3.setText(avl.getInorder());
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
