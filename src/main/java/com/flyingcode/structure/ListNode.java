package com.flyingcode.structure;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " -> ");
      curr = curr.next;
    }
  }

  public static ListNode createList(int[] nums) {
    if (nums.length == 0) {
      return null;
    }
    ListNode head = new ListNode(nums[0]);
    ListNode curr = head;
    for (int i = 1; i < nums.length; i++) {
      curr.next = new ListNode(nums[i]);
      curr = curr.next;
    }
    return head;
  }

  public static boolean matchList(ListNode head, int[] expected) {
    ListNode curr = head;
    int i = 0;
    while (curr != null) {
      if (i >= expected.length || curr.val != expected[i]) {
        return false;
      }
      curr = curr.next;
      i++;
    }
    return i == expected.length;
  }
}
