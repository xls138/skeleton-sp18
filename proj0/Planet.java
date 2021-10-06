/**
 * Planet
 */
public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet(Planet p){
        this(p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
    }
    double calcDistance(Planet p){
        double r;
        r=Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
        return r;
    }
    double calcForceExertedBy(Planet p){
        double r;
        double f;
        r = this.calcDistance(p);
        f = 6.67*1E-11*this.mass*p.mass/(r*r);
        return f;
    }
    double calcForceExertedByX(Planet p){
        double r;
        double f;
        double fx;
        r = this.calcDistance(p);
        f = this.calcForceExertedBy(p);
        fx = f*(p.xxPos-this.xxPos)/r;
        return fx;    
    }
    double calcForceExertedByY(Planet p){
        double r;
        double f;
        double fy;
        r = this.calcDistance(p);
        f = this.calcForceExertedBy(p);
        fy = f*(p.yyPos-this.yyPos)/r;
        return fy;    
    }

    double calcNetForceExertedByX(Planet[] p){
        double fx = 0.0;
        for (Planet planet : p) {
            if(this.equals(planet)){
                continue;
            }
            fx += this.calcForceExertedByX(planet);
        }
        return fx;
    }
    double calcNetForceExertedByY(Planet[] p){
        double fy = 0.0;
        for (Planet planet : p) {
            if(this.equals(planet)){
                continue;
            }
            fy += this.calcForceExertedByY(planet);
        }
        return fy;
    }

    void update(double dt, double fX, double fY){
        double ax;
        double ay;
        ax = fX/this.mass;
        ay = fY/this.mass;
        this.xxVel = this.xxVel + ax*dt;
        this.yyVel = this.yyVel + ay*dt;
        this.xxPos = this.xxPos + this.xxVel*dt;
        this.yyPos = this.yyPos + this.yyVel*dt;
    }

    void draw(){
        String img_root = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, img_root);
    }
}