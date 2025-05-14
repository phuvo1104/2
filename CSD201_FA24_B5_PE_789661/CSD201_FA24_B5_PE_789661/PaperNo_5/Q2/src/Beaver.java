// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Beaver {
  String place;
  int depth,type;
  Beaver() {
   }
  Beaver(String xPlace, int xDepth, int xType){
    place=xPlace;depth=xDepth; type=xType;
   }
  public String toString(){
    return("(" +place+","+depth + "," + type + ")");
   }
 }
