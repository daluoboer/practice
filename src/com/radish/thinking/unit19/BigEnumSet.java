package com.radish.thinking.unit19;

import java.util.EnumSet;

public class BigEnumSet {
    enum Big {
        A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44, A45, A46, A47, A48, A49, A50, A51, A52, A53, A54, A55, A56, A57, A58, A59, A60, A61, A62, A63, A64, A65, A66, A67, A68, A69, A70, A71, A72, A73, A74, A75
    }

    public static void main(String[] args) {
        EnumSet<Big> bigEnumSet = EnumSet.allOf(Big.class);
        System.out.println(bigEnumSet);
    }

    /*public static void main(String[] args) {
        String a = "A0\n" +
                "A1\n" +
                "A2\n" +
                "A3\n" +
                "A4\n" +
                "A5\n" +
                "A6\n" +
                "A7\n" +
                "A8\n" +
                "A9\n" +
                "A10\n" +
                "A11\n" +
                "A12\n" +
                "A13\n" +
                "A14\n" +
                "A15\n" +
                "A16\n" +
                "A17\n" +
                "A18\n" +
                "A19\n" +
                "A20\n" +
                "A21\n" +
                "A22\n" +
                "A23\n" +
                "A24\n" +
                "A25\n" +
                "A26\n" +
                "A27\n" +
                "A28\n" +
                "A29\n" +
                "A30\n" +
                "A31\n" +
                "A32\n" +
                "A33\n" +
                "A34\n" +
                "A35\n" +
                "A36\n" +
                "A37\n" +
                "A38\n" +
                "A39\n" +
                "A40\n" +
                "A41\n" +
                "A42\n" +
                "A43\n" +
                "A44\n" +
                "A45\n" +
                "A46\n" +
                "A47\n" +
                "A48\n" +
                "A49\n" +
                "A50\n" +
                "A51\n" +
                "A52\n" +
                "A53\n" +
                "A54\n" +
                "A55\n" +
                "A56\n" +
                "A57\n" +
                "A58\n" +
                "A59\n" +
                "A60\n" +
                "A61\n" +
                "A62\n" +
                "A63\n" +
                "A64\n" +
                "A65\n" +
                "A66\n" +
                "A67\n" +
                "A68\n" +
                "A69\n" +
                "A70\n" +
                "A71\n" +
                "A72\n" +
                "A73\n" +
                "A74\n" +
                "A75\n" +
                "A76\n" +
                "A77\n" +
                "A78\n" +
                "A79\n" +
                "A80\n" +
                "A81\n" +
                "A82\n" +
                "A83\n" +
                "A84\n" +
                "A85\n" +
                "A86\n" +
                "A87\n" +
                "A88\n" +
                "A89\n" +
                "A90\n" +
                "A91\n" +
                "A92\n" +
                "A93\n";
        List<String> list = Arrays.asList(a.split("\n"));
        System.out.println(list);
    }*/
}
