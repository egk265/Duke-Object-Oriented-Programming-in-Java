import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
    int total = 0;
    for(Point p : s.getPoints())
    {
        total+=1;
    }    
    return total;
    }

    public double getAverageLength(Shape s) {
        // Put code here
    double average = 0;
    double perimeter = getPerimeter(s);
    int numSides = getNumPoints(s);
    average = perimeter/numSides;
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;

        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {

            double currDist = prevPt.distance(currPt);

            if(currDist>largestSide)
            {
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        for(Point currPt: s.getPoints())
        {
            if(currPt.getX()>largestX)
            {
                largestX = currPt.getX();
            }
        }    
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {

            FileResource fr = new FileResource(f);    
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter>largestPerimeter)
            {
                largestPerimeter = perimeter;
            }
            
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestPerimeter = 0.0;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter>largestPerimeter)
            {
                largestPerimeter = perimeter;
                temp = f;
            }
            
        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("number of points ="+numPoints);
        double averageLength = getAverageLength(s);
        System.out.println("average length = "+averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("largest side = "+largestSide);
        double largestX = getLargestX(s);
        System.out.println("largest x = "+largestX);
        System.out.println("Test Perimemter FINISHED XXXXXXXXXXX");
        System.out.println();
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("testPerimeterMultipleFiles = "+ getLargestPerimeterMultipleFiles());
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with largest perimemter = "+ getFileWithLargestPerimeter());
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //System.out.println("Test perimeter STARTED: XXXXXXXXXXXXXX");
        //pr.testPerimeter();
        //System.out.println();
        System.out.println("Test Perimeter Multiple Files: ");
        pr.testPerimeterMultipleFiles();
        System.out.println();
        System.out.println("File with Largest Perimeter");
        pr.testFileWithLargestPerimeter();
    }
}


