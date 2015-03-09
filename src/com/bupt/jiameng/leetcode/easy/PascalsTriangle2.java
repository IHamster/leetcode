package com.bupt.jiameng.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/9.
 */
//Given an index k, return the kth row of the Pascal's triangle.
//
//        For example, given k = 3,
//        Return [1,3,3,1]
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i < rowIndex + 1; i++){
            row.add(0,1);
            for(int j = 1; j < row.size() - 1; j++){
                row.set(j, row.get(j)+row.get(j+1));
            }
        }
        return row;
    }

    public static void main(String[] args){
        PascalsTriangle2 p2 = new PascalsTriangle2();
        System.out.println(p2.getRow(3));
    }
}
