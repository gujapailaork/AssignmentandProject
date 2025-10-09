import java.util.Random;

class Student {

    private String code;
    private String name;
    private double gpa;

    Student(String code, String name, double gpa) {
        this.code = code;
        this.name = name;
        this.gpa = gpa;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return code + "-" + name + "-" + gpa + " ";
    }

}

class Node {

    private Student data;
    private Node left, right;

    public Node(Student item) {
        data = item;
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

    public void setLeft(Node x) {
        left = x;
    }

    public void setRight(Node x) {
        right = x;
    }

}

class BinarySearchTree {

    private Node root;
    private String inorder;

    public void insert(Student data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, Student data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.getCode().compareTo(root.getData().getCode()) < 0) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data.getCode().compareTo(root.getData().getCode()) > 0) {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    public void inorder() {
        inorder="";
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeft());
            //System.out.print(root.getData().toString() + " ");
            inorder+= root.getData().toString() + " ";
            inorderRec(root.getRight());
        }
    }
    
    public String getInorder() {
        return inorder;
    }
}

public class BSTTest extends javax.swing.JFrame {
    
    public static Student[] data;
    public static BinarySearchTree bst;
    
    public static Student genStudent() {
        Random r = new Random();
        String code = "" + r.nextInt(90)+10;
        String text1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text2 = "abcdefghijklmnopqrstuvwxyz";
        String name = ""+text1.charAt(r.nextInt(text1.length()-1));
        int n = r.nextInt(3)+3;
        for (int i = 0; i<n;i++){
            name += text2.charAt(r.nextInt(text2.length()-1));
        }
        name += " ";
        name += text1.charAt(r.nextInt(text1.length()-1));
        n = r.nextInt(3)+3;
        for (int i = 0; i<n;i++){
            name += text2.charAt(r.nextInt(text2.length()-1));
        }
        name += " ";
        
        double gpa = r.nextInt(4)+r.nextInt(100)/10;
        return new Student(code, name, gpa);
    }
    public BSTTest() {
        initComponents();

        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i<5; i++) {
            Student x = genStudent();
            System.out.println(x.toString());
            bst.insert(x);
        }
        System.out.println("Inorder Traversal");
        bst.inorder();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jButton2.setText("CreateBST");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 545, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }
    // genStudent botton
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int n = Integer.parseInt(jTextField1.getText());
        if (n == 0) {
            return;
        }
        data = new Student[n];
        String students = "";
        for (int i = 0; i<n; i++) {
            Student x = genStudent();
            data[i] = x;
            students += x.toString();
        }
        
        jTextField2.setText(students);
        
    }
    
// createbst
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (data == null) {
            return;
        }
        
        bst = new BinarySearchTree();
        for (int i = 0; i<data.length; i++) {
            bst.insert(data[i]);
        }
    }
    

// inoeder botton
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (bst ==null) {
            return;
        }
        
        bst.inorder();
        jTextField3.setText(bst.getInorder());
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BSTTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BSTTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BSTTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BSTTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BSTTest().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    
}
