package com.scaler.learn.flyweight;

public class FlyWeightTester {
  public static void main(String[] args) {
    testFlyweight();
  }

  private static void testFlyweight() {
    FlyWeightRegistry flyWeightRegistry = FlyWeightRegistry.getInstance();
    flyWeightRegistry.fillWith("player1", Flyweight.builder()
        .setAvatar(123).setInitialAmo(100).setInitialHealth(10).build());
    flyWeightRegistry.fillWith("player2", Flyweight.builder()
        .setAvatar(124).setInitialAmo(50).setInitialHealth(10).build());
    for (int i = 0; i < 200; i++) {
      if (i < 100) {
        Player player1 = Player.builder().setFlyweight(flyWeightRegistry.map.get("player1")).build();
        //System.out.println(player1.getFlyweight().getAvatar());
      } else {
        Player player2 = Player.builder().setFlyweight(flyWeightRegistry.map.get("player2")).build();
        //System.out.println(player2.getFlyweight().getAvatar());
      }
    }
  }
}
