// https://github.com/BancroftSchoolOpenSource/LetsPrintRobots-Courseware/releases
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins
import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
double height = 15
double width = 40
BasePlate = new Cube(20, width, height)
		.toCSG()
		.toZMin()
		.toYMin()
		.toXMin()
CSG Servo = Vitamins.get("hobbyServo", "mg92b")
		.roty(90)
		.toXMin()
		.toYMax()
		.toZMax()
		.movez(height)
		.movey(width)
BasePlate = BasePlate.difference(Servo)
		
return [BasePlate]