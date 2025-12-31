package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo034TicTacToe
 * 使用JUnit 5测试井字棋矩阵验证算法的正确性
 * 该测试类覆盖了有效盘面、无效盘面、获胜情况等多种测试场景
 */
class Algo034TicTacToeTest {

  /**
   * 测试有效盘面: 空棋盘
   */
  @Test
  @DisplayName("测试有效盘面: 空棋盘")
  void testValidBoardEmpty() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 0, 0, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };
    assertTrue(algo.solution(board), "空棋盘应被视为有效盘面");
  }

  /**
   * 测试有效盘面: X先下,X比O多1
   */
  @Test
  @DisplayName("测试有效盘面: X先下,X比O多1")
  void testValidBoardXPlaysFirst() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 0, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };

    assertTrue(algo.solution(board), "X先下,X比O多1的盘面应有效");
  }

  /**
   * 测试有效盘面: X和O数量相等
   */
  @Test
  @DisplayName("测试有效盘面: X和O数量相等")
  void testValidBoardEqualCounts() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 2, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };

    assertTrue(algo.solution(board), "X和O数量相等的盘面应有效");
  }

  /**
   * 测试有效盘面: X获胜, 且X数量比O多1
   */
  @Test
  @DisplayName("测试有效盘面: X获胜, 且X数量比O多1")
  void testValidBoardXWins() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 1, 1 },
        { 2, 2, 0 },
        { 0, 0, 0 }
    };

    assertTrue(algo.solution(board), "X获胜且X数量比O多1的盘面应有效");
  }

  /**
   * 测试有效盘面: O获胜, 且X和O数量相等
   */
  @Test
  @DisplayName("测试有效盘面: O获胜, 且X和O数量相等")
  void testValidBoardOWins() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 2, 2 },
        { 1, 2, 0 },
        { 2, 1, 1 }
    };

    assertTrue(algo.solution(board), "O获胜且X和O数量相等的盘面应有效");
  }

  /**
   * 测试无效盘面: O数量多于X
   */
  @Test
  @DisplayName("测试无效盘面: O数量多于X")
  void testInvalidBoardOCountGreaterThanX() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 2, 0, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };

    assertFalse(algo.solution(board), "O数量多于X的盘面应无效");
  }

  /**
   * 测试无效盘面: X数量比O多2个
   */
  @Test
  @DisplayName("测试无效盘面: X数量比O多2个")
  void testInvalidBoardXCountTooLarge() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 1, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };

    assertFalse(algo.solution(board), "X数量比O多2个的盘面应无效");
  }

  /**
   * 测试无效盘面: X和O同时获胜
   */
  @Test
  @DisplayName("测试无效盘面: X和O同时获胜")
  void testInvalidBoardBothWins() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 1, 1 },
        { 2, 2, 2 },
        { 0, 0, 0 }
    };

    assertFalse(algo.solution(board), "X和O同时获胜的盘面应无效");
  }

  /**
   * 测试无效盘面: X获胜但X数量不等于O数量+1
   */
  @Test
  @DisplayName("测试无效盘面: X获胜但X数量不等于O数量+1")
  void testInvalidBoardXWinsWrongCount() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 1, 1 },
        { 2, 2, 0 },
        { 2, 0, 0 }
    };

    assertFalse(algo.solution(board), "X获胜但X数量不等于O数量+1的盘面应无效");
  }

  /**
   * 测试无效盘面: O获胜但X数量不等于O数量
   */
  @Test
  @DisplayName("测试无效盘面: O获胜但X数量不等于O数量")
  void testInvalidBoardOWinsWrongCount() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 2, 2 },
        { 2, 1, 1 },
        { 2, 1, 2 }
    };

    assertFalse(algo.solution(board), "O获胜但X数量不等于O数量的盘面应无效");
  }

  /**
   * 测试有效盘面: X在对角线获胜
   */
  @Test
  @DisplayName("测试有效盘面: X在对角线获胜")
  void testValidBoardXWinsDiagonal() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 2, 0 },
        { 2, 1, 0 },
        { 0, 0, 1 }
    };

    assertTrue(algo.solution(board), "X在对角线获胜的盘面应有效");
  }

  /**
   * 测试有效盘面: O在列获胜
   */
  @Test
  @DisplayName("测试有效盘面: O在列获胜")
  void testValidBoardOWinsColumn() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 2, 1 },
        { 1, 2, 0 },
        { 2, 2, 1 }
    };

    assertTrue(algo.solution(board), "O在列获胜的盘面应有效");
  }

  /**
   * 测试有效盘面: 填满的棋盘
   */
  @Test
  @DisplayName("测试有效盘面: 填满的棋盘")
  void testValidBoardFullBoard() {
    Algo034TicTacToe algo = new Algo034TicTacToe();
    int[][] board = {
        { 1, 2, 1 },
        { 2, 1, 2 },
        { 1, 2, 1 }
    };

    assertTrue(algo.solution(board), "填满的棋盘应被视为有效盘面");
  }
}
