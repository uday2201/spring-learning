package com.example.spring_learning.datastructures.tree;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}
