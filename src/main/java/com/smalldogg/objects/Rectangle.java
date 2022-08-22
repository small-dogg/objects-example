package com.smalldogg.objects;

/**
 * 캡슐화 예제
 *
 * 우리가 객체를 설계할 때 2가지 관점을 고려해야한다.
 * 이 객체가 어떤 데이터를 포함해야 하는가?
 * 이 객체가 데이터에 대해 수행해야 하는 오퍼레이션은 무엇인가?
 */
public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    /**
     * setRight와 setBottom을 제공함으로써, Rectangle클래스는 상태를 노출하게되고, 이에따라 캡슐화를 위반하게 된다.
     * setRight와 setBottom을 제공하는 목적이 사각형의 크기를 증가시키는 기능을 제공하기 위해서였는데,
     * 이는 협력을 고려하지 못하였다. 다시말해, 이 Rectangle 클래스를 사용할 클래스를 고려하지 못하였기 때문에,
     * 데이터 기반의 설계로 이게 필요하겠지? 라는 생각으로 이 메서드가 제공된 것이다.
     * Rectangle을 사용할 대상이 크기 확장도 필요하다는 것을 인지하고 있었다면(협력대상을 헤아릴 수 있었다면)
     * setter 메서드보단 enLarge 메서드 처럼 값을 받아 내부 상태를 변경하는(캡슐화) 방식으로 바꿔야한다.
     * Rectangle을 변경하는 주체를 외부의 객체에서 Rectangle로 이동시켰다. 즉, 자신의 크기를 Rectangle 스스로 증가시키도록
     * '책임을 이동'시킨것이다. 이것이 바로 객체가 자기 스스로를 책임진다는 말의 의미이다.
     */
    public void setRight(int right) {
        this.right = right;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public void enlarge(int multiple){
        right += multiple;
        bottom += multiple;
    }
}

class AnyClass{
    void anyMethod(Rectangle rectangle, int multiple) {
//        rectangle.setRight(rectangle.getRight() + multiple);
//        rectangle.setBottom(rectangle.getBottom() + multiple);
        rectangle.enlarge(multiple);
    }
}