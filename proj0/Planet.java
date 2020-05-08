public class Planet {
    public double xxPos; //Its current x position
    public double yyPos; //Its current y position
    public double xxVel; //Its current velocity in the x direction
    public double yyVel; //Its current velocity in the y direction
    public double mass; //Its mass
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double disX = p.xxPos - this.xxPos;
        double disY = p.yyPos - this.yyPos;
        double sDx = disX * disX;
        double sDy = disY * disY;
        return Math.sqrt(sDx + sDy);
    }

    public double calcForceExertedBy(Planet p){
        double squareDis = this.calcDistance(p)*this.calcDistance(p);
        return (6.67e-11 * p.mass * this.mass)/squareDis;
    }

    public double calcForceExertedByX(Planet p){
        double disX = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p)* disX/this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        double disY = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p)* disY/this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double allForceByX = 0;
        for (int i=0; i < allPlanets.length; i++){
            if (!allPlanets[i].equals(this)){
                allForceByX = allForceByX + calcForceExertedByX(allPlanets[i]);
            }
        }
        return allForceByX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double allForceByY = 0;
        for (int i=0; i < allPlanets.length; i++){
            if (!allPlanets[i].equals(this)){
                allForceByY = allForceByY + calcForceExertedByY(allPlanets[i]);
            }
        }
        return allForceByY;
    }

    public void update(double dT, double xChnage, double yChange){
        double aX = xChnage/this.mass;
        double aY = yChange/this.mass;
        xxVel = this.xxVel + dT * aX;
        yyVel = this. yyVel + dT * aY;
        xxPos = this.xxPos + dT * xxVel;
        yyPos = this.yyPos + dT * yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos,"images/"+ this.imgFileName);

    }


}
