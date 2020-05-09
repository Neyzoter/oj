package cn.neyzoter.module.proxy;

/**
 * Apple impl Fruit
 * @author Charles Song
 * @date 2020-5-9
 */
public class Apple implements Fruit{
    /**
     * fruit name
     */
    private String name;

    public Apple () {
        this.name = "Apple";
    }
    @Override
    public String getName () {
        System.out.println(this.name);
        return this.name;
    }
}
