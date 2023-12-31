// https://github.com/BancroftSchoolOpenSource/LetsPrintRobots-Courseware/releases
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins
import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
double height = 15
double width = 40
double length = 20
double insety = 6
double insetx = 4
BasePlate = new Cube(length, width, height)
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
CSG Screw = Vitamins.get("chamferedScrew", "M3x16")
		.toZMin()
		.move(insetx, insety+2, 0)
CSG Screw2 = Screw.movey(width-insety-5)
BasePlate = BasePlate.difference([Servo,Screw,Screw2])
CSG Cover = new Cube(length, 35, 2)
		.toCSG()
		.toZMin()
		.toYMin()
		.toXMin()
		.movez(height)
		.movey(5)
Cover = Cover.difference([Screw,Screw2])
CSG text = CSG.text("Jaicob M",0.7,2.5)
		.movez(height+2)
		.movex(10)
		.movey(width-3)
CSG text2 = text.rot(-90, 0, 0)
		.toZMin()
		.toYMin()
		.movex(-30)
		.movey(width)
		.mirrorx()
		.movez(13)
BasePlate = BasePlate.union(text2)
Cover = Cover.union(text)
CoverM = Cover.toZMin()
		.movex(length+1)
return [BasePlate,CoverM]