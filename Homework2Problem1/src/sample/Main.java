package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;


public class Main extends Application {

    public int getDayIndex(DayOfWeek day) {
        switch (day) {
            case MONDAY: {
                return 1;
            }
            case TUESDAY: {
                return 2;
            }
            case WEDNESDAY: {
                return 3;
            }
            case THURSDAY: {
                return 4;
            }
            case FRIDAY: {
                return 5;
            }
            case SATURDAY: {
                return 6;
            }
            case SUNDAY: {
                return 7;
            }
            default:
                return 0;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group group = new Group();
        Scene scene = new Scene(group, 400, 200);

        int startX = 90;
        int startY = 70;

        TextInputDialog YearInput = new TextInputDialog();
        YearInput.setHeaderText("Enter year.");
        YearInput.setTitle("Year input");
        YearInput.setContentText("Year: ");

        TextInputDialog MonthInput = new TextInputDialog();
        MonthInput.setHeaderText("Enter month.");
        MonthInput.setTitle("Month Input");
        MonthInput.setContentText("Month: ");

        Optional<String> result = YearInput.showAndWait();
        double year = Double.parseDouble(result.get());
        Optional<String> result1 = MonthInput.showAndWait();
        double month = Double.parseDouble(result1.get());

        Text DaysInTheWeek = new Text(80, 50, "MON  TUE  WED  THR  FRI  SAT  SUN");
        DaysInTheWeek.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        DaysInTheWeek.setStroke(Color.BLACK);
        group.getChildren().add(DaysInTheWeek);

        LocalDate date = LocalDate.of((int) year, (int) month, 1);
        int index = getDayIndex(date.getDayOfWeek());

        YearMonth yearMonth = YearMonth.of((int) year, (int) month);
        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate today = LocalDate.now();
        int todayDay = today.getDayOfMonth();
        int todayMonth = today.getMonthValue();
        int todayYear = today.getYear();

        for (int i = 2 - index; i <= daysInMonth; i++) {

            for (int j = 0; j < 7; j++) {

                if (i > daysInMonth)
                    break;

                if (i >= 1) {
                    Text dayIndex = new Text(startX, startY, String.format("%d", i));
                    if (i == todayDay && todayMonth == month && todayYear == year) {
                        dayIndex.setStroke(Color.RED);
                    }

                    group.getChildren().add(dayIndex);

                } else {
                    Text spaces = new Text(startX, startY, "  ");
                    group.getChildren().add(spaces);
                }

                i++;
                startX += 35;
            }
            i--;
            startX = 90;
            startY += 20;
        }

        primaryStage.setTitle("Calendar for " + yearMonth.getMonth() + " " + yearMonth.getYear());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

