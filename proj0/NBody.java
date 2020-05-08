public class NBody {

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int numPlanets = in.readInt();
        double radius = in.readDouble();

//        while (!in.isEmpty()) {
//            for (int i = 0; i < numPlanets; i++) {
//                double xCor = in.readDouble();
//                double yCor = in.readDouble();
//                double xVel = in.readDouble();
//                double yVel = in.readDouble();
//                double mass = in.readDouble();
//                if (mass < 0) {
//                    continue;
//                }
//                String image = in.readString();
//            }
//        }
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int numPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[numPlanets];

        while (!in.isEmpty()) {
            for (int i = 0; i < numPlanets; i++) {
                Planet p_new = new Planet(1.0, 1.0, 1.0, 1.0, 1.0,"sample");
                p_new.xxPos = in.readDouble();
                p_new.yyPos = in.readDouble();
                p_new.xxVel = in.readDouble();
                p_new.yyVel = in.readDouble();
                p_new.mass = in.readDouble();
//                if (mass < 0) {
//                    continue;
//                }
                p_new.imgFileName = in.readString();
                planets[i] = p_new;
            }
            break;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] allPlanets = readPlanets(filename);
        double r = readRadius(filename);

        StdDraw.setScale(-r, r);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Show the universe. */
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : allPlanets){
            p.draw();
        }

        /* Enable double buffering */
        StdDraw.enableDoubleBuffering();
        for(double t = 0.0; t <= T; t += dt){
            double[] xForces = new double[allPlanets.length];
            double[] yForces = new double[allPlanets.length];
            for (int i = 0; i < allPlanets.length; i ++){
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
                StdDraw.clear();
                StdDraw.picture(0, 0, "images/starfield.jpg");
            }
            for(int i = 0; i < allPlanets.length; i ++){
                allPlanets[i].update(dt,xForces[i],yForces[i]);
                allPlanets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

        }

        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < allPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                    allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }
    }

}

