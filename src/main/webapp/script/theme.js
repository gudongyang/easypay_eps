document.write("<link href='" + appRoot + "css/style.css' type=text/css rel=stylesheet>");
document.write("<link href='" + appRoot + "css/qt.css' type=text/css rel=stylesheet>");
/*Read the theme config from user cookie*/
var stylefile = "red";
var frameColor = "#DE3A41";
var skinName = Cookie.read("userskin");
if (skinName != "" && skinName != null) {
    stylefile = skinName;
    if (skinName == "red") frameColor = "#DE3A41";
    if (skinName == "gray") frameColor = "#7E7E7E";
    if (skinName == "blue") frameColor = "#3A62DC";
    if (skinName == "green") frameColor = "#46A848";
}
document.write("<link href='" + appRoot + "css/" + stylefile + ".css' type=text/css rel=stylesheet>");

