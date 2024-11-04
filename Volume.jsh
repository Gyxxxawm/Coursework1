public class Volume {
    public static double sphere(double d) {
        double radius = d / 2;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        return volume;
    }

    public static void main(String[] args) {
        double diameter = 20.24;
        double result = sphere(diameter);
        System.out.println(result);
    }
}