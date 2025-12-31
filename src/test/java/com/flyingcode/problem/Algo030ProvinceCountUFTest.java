package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo030ProvinceCountUF
 * 使用JUnit 5测试基于并查集(Union-Find)算法的省份数量计算算法的正确性
 */
class Algo030ProvinceCountUFTest {

  /**
   * 测试基本功能: 包含三个独立省份的标准图
   *
   * 图结构:
   * 省份1: 城市0 - 城市1
   * 省份2: 城市2
   * 省份3: 城市3 - 城市4
   */
    @Test
    @DisplayName("测试包含三个独立省份的标准图")
    void testStandardGraphWithThreeProvinces() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 0, 0, 0},
      {1, 1, 0, 0, 0},
      {0, 0, 1, 0, 0},
      {0, 0, 0, 1, 1},
      {0, 0, 0, 1, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(3, result, "图包含城市[0-1], [2], [3-4], 应该有3个省份");
  }

  /**
   * 测试单个省份: 所有城市都连通
   *
   * 图结构:
   * 所有5个城市都连通, 形成完全图
   */
    @Test
    @DisplayName("测试所有城市连通形成的单个省份")
    void testAllCitiesConnectedInOneProvince() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(1, result, "所有5个城市都连通, 应该形成1个省份");
  }

  /**
   * 测试边界条件: 空矩阵
   */
    @Test
    @DisplayName("测试边界条件: 空矩阵")
    void testEmptyMatrix() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {};
        int result = algo.solution(isConnected);
        assertEquals(0, result, "空矩阵应该返回0个省份");
  }

  /**
   * 测试边界条件: null矩阵
   */
    @Test
    @DisplayName("测试边界条件: null矩阵")
    void testNullMatrix() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = null;
        int result = algo.solution(isConnected);
        assertEquals(0, result, "null矩阵应该返回0个省份");
  }

  /**
   * 测试单个城市
   */
    @Test
    @DisplayName("测试单个城市")
    void testSingleCity() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {{1}};
        int result = algo.solution(isConnected);
        assertEquals(1, result, "单个城市应该形成1个省份");
  }

  /**
   * 测试城市之间没有连接(每个城市各自是一个省份)
   *
   * 图结构:
   * 5个城市没有连接, 每个都是独立的省份
   */
    @Test
    @DisplayName("测试没有连接: 每个城市各自是一个省份")
    void testNoConnectionsAllIsolatedCities() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 0, 0, 0, 0},
      {0, 1, 0, 0, 0},
      {0, 0, 1, 0, 0},
      {0, 0, 0, 1, 0},
      {0, 0, 0, 0, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(5, result, "5个孤立城市没有连接, 应该形成5个省份");
  }

  /**
   * 测试线性链连接(路径图)
   *
   * 图结构:
   * 城市0 - 城市1 - 城市2 - 城市3 - 城市4
   * 所有城市连成一条线, 形成1个省份
   */
    @Test
    @DisplayName("测试线性链连接: 所有城市连成一条线")
    void testLinearChainConnection() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 0, 0, 0},
      {1, 1, 1, 0, 0},
      {0, 1, 1, 1, 0},
      {0, 0, 1, 1, 1},
      {0, 0, 0, 1, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(1, result, "线性链连接应该形成1个省份");
  }

  /**
   * 测试两个独立的连通分量
   *
   * 图结构:
   * 省份1: 城市0 - 城市1 - 城市2
   * 省份2: 城市3 - 城市4
   */
    @Test
    @DisplayName("测试两个独立的连通分量")
    void testTwoDisconnectedComponents() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 1, 0, 0},
      {1, 1, 1, 0, 0},
      {1, 1, 1, 0, 0},
      {0, 0, 0, 1, 1},
      {0, 0, 0, 1, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(2, result, "两个独立的连通分量[0-1-2]和[3-4]应该形成2个省份");
  }

  /**
   * 测试星型拓扑(一个中心城市连接所有其他城市)
   *
   * 图结构:
   * 城市0
   * / | \
   * 1  2  3
   * |
   * 4
   * 所有城市通过城市0连接, 形成1个省份
   */
    @Test
    @DisplayName("测试星型拓扑: 中心城市连接所有其他城市")
    void testStarTopology() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 1, 1, 1},
      {1, 1, 0, 0, 0},
      {1, 0, 1, 0, 0},
      {1, 0, 0, 1, 0},
      {1, 0, 0, 0, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(1, result, "星型拓扑中中心城市0连接所有城市, 应该形成1个省份");
  }

  /**
   * 测试复杂图: 包含多个不同大小的省份
   *
   * 图结构:
   * 省份1: 城市0-1-2-3 (4个城市)
   * 省份2: 城市4-5 (2个城市)
   * 省份3: 城市6 (1个城市)
   * 省份4: 城市7-8-9 (3个城市)
   */
    @Test
    @DisplayName("测试复杂图: 包含多个不同大小的省份")
    void testComplexGraphWithMultipleProvinces() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
      {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 0, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(4, result, "复杂图应该有4个省份, 大小分别为[4, 2, 1, 3]");
  }

  /**
   * 测试非对称连接(仍然形成有效的无向图)
   *
   * 图结构:
   * 省份1: 城市0-1-2 (三角形)
   * 省份2: 城市3-4 (对)
   */
    @Test
    @DisplayName("测试省份内的非对称连接")
    void testAsymmetricConnections() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 0, 0, 0},
      {1, 1, 1, 0, 0},
      {0, 1, 1, 0, 0},
      {0, 0, 0, 1, 1},
      {0, 0, 0, 1, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(2, result, "非对称连接仍然应该形成2个省份[0-1-2]和[3-4]");
  }

  /**
   * 测试大图: 包含连通分量和多个孤立城市
   *
   * 图结构:
   * 省份1: 城市0-1-2-3-4 (5个城市连通)
   * 城市5-9: 每个都是孤立城市 (5个城市)
   * 总计: 6个省份
   */
    @Test
    @DisplayName("测试大图: 包含连通分量和多个孤立城市")
    void testLargeGraphWithManyIsolatedCities() {
        Algo030ProvinceCountUF algo = new Algo030ProvinceCountUF();
        int[][] isConnected = {
      {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
    };
        int result = algo.solution(isConnected);
        assertEquals(6, result, "包含1个5城市连通分量和5个孤立城市的图应该有6个省份");
  }
}
