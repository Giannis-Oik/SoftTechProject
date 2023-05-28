import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Exercise_Plan
{
    private ArrayList<Exercise> Monday = new ArrayList<Exercise>();
    private ArrayList<Exercise> Tuesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> Wednesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> Thursday = new ArrayList<Exercise>();
    private ArrayList<Exercise> Friday = new ArrayList<Exercise>();
    private ArrayList<Exercise> Saturday = new ArrayList<Exercise>();
    
    public Exercise_Plan(){}
    
    static void Make_ExPlan(User_profile u, ArrayList<Exercise> ExerciseList)
    {
        Exercise_Plan plan = new Exercise_Plan();
        
        int days = 0, type = 0;
        
        System.out.println("The cconstruction of your exercise plan has began.You will now be presented with the available options.");
        
        plan.Show_Options(days, type);
        
        plan.Make_Plan(days,type,ExerciseList);
        
        plan.Show_Plan(type);
        
        plan.Make_changes();
        
        plan.Save_plan(u);
        
        return;
    }
    
    private void Show_Options(int days, int type) //Methodos poy deixnei tis epiloges sto xrhsth anaforika me to poses meres tha gymnazetai kai se th typo gymanstikhs endiaferetai.
    {
        System.out.println("The options are of two categories: 1)#of days to workout in a week, 2)type of workouts.");
        System.out.println("To begin you have to choose the #of days to workout.Your choice must be an integer number between 1 and 6.");
        
        Scanner input = new Scanner(System.in);
        
        int choice = input.nextInt();
        
        while(choice > 6 || choice < 1)
        {
            System.out.println("Your choice was invalid. Please make another one using a number from 1 to 6.");
            choice = input.nextInt();
        }
        
        days = choice;
       
        System.out.println("Now you have to choose the type of workout you wish for.The available choices are:\n1)Weight Loss(More cardio)\n2)Strength(Weight training)\n3)Flexibility");
        
        System.out.println("Please make your choice using the corresponding number(1 to 4).");
        
        choice = input.nextInt();
        
        while(choice > 3 || choice < 1)
        {
            System.out.println("Your choice was invalid. Please make another one using a number from 1 to 4.");
            choice = input.nextInt();
        }
        
        type = choice;
        
        return;
    }
    
    private void Make_Plan(int days, int type, ArrayList<Exercise> ExerciseList)
    {
        Collections.shuffle(ExerciseList);
        Exercise e;
        int cardio,chest,back,shoulders,legs,bic,tric,abs,flex,i;
        switch(type) //Switch poy xwrizei toys 3 typous gymnastikhs kai vash ths epiloghs dinei antistoixo programma.
        {
            case 1: //Cardio(Weight Loss)
            switch(days) //Switch poy kathorizei tis meres gymnastikhs vash ths epiloghs
                {
                    case 1: //Mia mera ths vdomadas
                         cardio = 4;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                             e = ExerciseList.get(i);
                             
                             if((e.getType() == "Low Cardio") || (e.getType() == "Medium Cardio") || (e.getType() == "High Cardio") && cardio > 0)
                             {
                                 Wednesday.add(e);
                                 cardio--;
                             }
                         }
                         break;
                    case 2: //Dyo meres ths vdomadas
                         cardio = 3; chest = 2; back = 2; legs = 1; 
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                             e = ExerciseList.get(i);
                             
                             if((e.getType() == "Low Cardio") || (e.getType() == "Medium Cardio") || (e.getType() == "High Cardio") && (cardio > 0))
                             {
                                 Tuesday.add(e);
                                 Thursday.add(e);
                                 cardio--;
                             }else if((e.getMuscles() == "Chest")&& (chest > 0))
                             {
                                 Tuesday.add(e);
                                 chest--;
                             }else if((e.getMuscles() == "Back")&& (back > 0))
                             {
                                 Thursday.add(e);
                                 back--;
                             }else if((e.getMuscles() == "Legs")&& (legs > 0))
                             {
                                 Tuesday.add(e);
                                 Thursday.add(e);
                                 legs--;
                             }
                         }
                         break;
                    case 3: //Treis meres ths vdomadas
                         cardio = 3; chest = 2; back = 2; legs = 2; bic = 1; tric = 1; abs = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                             e = ExerciseList.get(i);
                             
                             if((e.getType() == "Low Cardio") || (e.getType() == "Medium Cardio") || (e.getType() == "High Cardio") && (cardio > 0))
                             {
                                 Monday.add(e);
                                 Wednesday.add(e);
                                 Friday.add(e);
                                 cardio--;
                             }else if((e.getMuscles() == "Chest")&& (chest > 0))
                             {
                                 Monday.add(e);
                                 chest--;
                             }else if((e.getMuscles() == "Back")&& (back > 0))
                             {
                                 Wednesday.add(e);
                                 back--;
                             }else if((e.getMuscles() == "Legs")&& (legs > 0))
                             {
                                 Friday.add(e);
                                 legs--;
                             }else if((e.getMuscles() == "Biceps")&& (bic > 0))
                             {
                                 Monday.add(e);
                                 bic--;
                             }else if((e.getMuscles() == "Triceps")&& (tric > 0))
                             {
                                 Wednesday.add(e);
                                 tric--;
                             }else if((e.getMuscles() == "Abs")&& (abs > 0))
                             {
                                 Friday.add(e);
                                 abs--;
                             }
                         }
                         break;
                    case 4: //Tesseris meres ths vdomadas
                         cardio = 3; chest = 2; back = 2; legs = 2; shoulders = 2; bic = 1; tric = 1; abs = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                             e = ExerciseList.get(i);
                             
                             if((e.getType() == "Low Cardio") || (e.getType() == "Medium Cardio") || (e.getType() == "High Cardio") && (cardio > 0))
                             {
                                 Monday.add(e);
                                 Tuesday.add(e);
                                 Thursday.add(e);
                                 Friday.add(e);
                                 cardio--;
                             }else if((e.getMuscles() == "Chest")&& (chest > 0))
                             {
                                 Monday.add(e);
                                 chest--;
                             }else if((e.getMuscles() == "Back")&& (back > 0))
                             {
                                 Tuesday.add(e);
                                 back--;
                             }else if((e.getMuscles() == "Shoulders")&& (shoulders > 0))
                             {
                                 Thursday.add(e);
                                 shoulders--;
                             }else if((e.getMuscles() == "Legs")&& (legs > 0))
                             {
                                 Friday.add(e);
                                 legs--;
                             }else if((e.getMuscles() == "Biceps")&& (bic > 0))
                             {
                                 Tuesday.add(e);
                                 bic--;
                             }else if((e.getMuscles() == "Triceps")&& (tric > 0))
                             {
                                 Thursday.add(e);
                                 tric--;
                             }else if((e.getMuscles() == "Abs")&& (abs > 0))
                             {
                                 Monday.add(e);
                                 Friday.add(e);
                                 abs--;
                             }
                         }
                         break;
                    case 5: //Pente meres ths vdomadas
                         cardio = 6; chest = 2; back = 2; legs = 2; shoulders = 2; bic = 1; tric = 1; abs = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                             e = ExerciseList.get(i);
                             
                             if((e.getType() == "Low Cardio") || (e.getType() == "Medium Cardio") && (cardio > 3))
                             {
                                 Monday.add(e);
                                 Tuesday.add(e);
                                 Thursday.add(e);
                                 Friday.add(e);
                                 cardio--;
                             }else if((e.getType() == "High Cardio") && (cardio > 0))
                             {
                                 Saturday.add(e);
                                 cardio--;
                             }else if((e.getMuscles() == "Chest")&& (chest > 0))
                             {
                                 Monday.add(e);
                                 chest--;
                             }else if((e.getMuscles() == "Back")&& (back > 0))
                             {
                                 Tuesday.add(e);
                                 back--;
                             }else if((e.getMuscles() == "Shoulders")&& (shoulders > 0))
                             {
                                 Thursday.add(e);
                                 shoulders--;
                             }else if((e.getMuscles() == "Legs")&& (legs > 0))
                             {
                                 Friday.add(e);
                                 legs--;
                             }else if((e.getMuscles() == "Biceps")&& (bic > 0))
                             {
                                 Tuesday.add(e);
                                 bic--;
                             }else if((e.getMuscles() == "Triceps")&& (tric > 0))
                             {
                                 Thursday.add(e);
                                 tric--;
                             }else if((e.getMuscles() == "Abs")&& (abs > 0))
                             {
                                 Monday.add(e);
                                 Friday.add(e);
                                 abs--;
                             }
                         }
                         break;
                    case 6: //Exi meres ths vdomadas
                         cardio = 6; chest = 2; back = 2; legs = 2; shoulders = 2; bic = 1; tric = 1; abs = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                             e = ExerciseList.get(i);
                             
                             if((e.getType() == "Low Cardio") || (e.getType() == "Medium Cardio") && (cardio > 3))
                             {
                                 Monday.add(e);
                                 Tuesday.add(e);
                                 Thursday.add(e);
                                 Friday.add(e);
                                 cardio--;
                             }else if((e.getType() == "High Cardio") && (cardio > 0))
                             {
                                 Wednesday.add(e);
                                 Saturday.add(e);
                                 cardio--;
                             }else if((e.getMuscles() == "Chest")&& (chest > 0))
                             {
                                 Monday.add(e);
                                 chest--;
                             }else if((e.getMuscles() == "Back")&& (back > 0))
                             {
                                 Tuesday.add(e);
                                 back--;
                             }else if((e.getMuscles() == "Shoulders")&& (shoulders > 0))
                             {
                                 Thursday.add(e);
                                 shoulders--;
                             }else if((e.getMuscles() == "Legs")&& (legs > 0))
                             {
                                 Friday.add(e);
                                 legs--;
                             }else if((e.getMuscles() == "Biceps")&& (bic > 0))
                             {
                                 Tuesday.add(e);
                                 bic--;
                             }else if((e.getMuscles() == "Triceps")&& (tric > 0))
                             {
                                 Thursday.add(e);
                                 tric--;
                             }else if((e.getMuscles() == "Abs")&& (abs > 0))
                             {
                                 Monday.add(e);
                                 Friday.add(e);
                                 abs--;
                             }
                         }
                         break;
                }
                break;
            case 2: //Strength(Weight Training)
                switch(days) //Switch poy kathorizei tis meres gymnastikhs vash ths epiloghs
                {
                    case 1: //Mia mera ths vdomadas
                         chest = 2; back = 2; shoulders = 2; legs = 2; bic = 1; tric = 1; abs = 1; cardio = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {   
                            e = ExerciseList.get(i);
                    
                            if((e.getMuscles() == "Chest") && (chest > 0))
                            {
                                Wednesday.add(e);
                                chest--;
                            }else if((e.getMuscles() == "Back") && (back > 0))
                            {
                                Wednesday.add(e);
                                back--;
                            }else if((e.getMuscles() == "Shoulders") && (shoulders > 0))
                            {
                                Wednesday.add(e);
                                shoulders--;
                            }else if((e.getMuscles() == "Legs") && (legs > 0))
                            {   
                                Wednesday.add(e);
                                legs--;
                            }else if((e.getMuscles() == "Biceps") && (bic > 0))
                            {
                                Wednesday.add(e);
                                bic--;
                            }else if((e.getMuscles() == "Triceps") && (tric > 0))
                            {
                                Wednesday.add(e);
                                tric--;
                            }else if((e.getMuscles() == "Abs") && (abs > 0))
                            {
                                Wednesday.add(e);
                                abs--;
                            }else if((e.getMuscles() == "All") && (cardio > 0))
                            {
                                Wednesday.add(e);
                                cardio--;
                            }
                         }
                         break;
                    case 2: //Dyo meres ths vdomadas
                         chest = 3; back = 3; shoulders = 3; legs = 3; bic = 1; tric = 1; abs = 1; cardio = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                    
                            if((e.getMuscles() == "Chest") && (chest > 0))
                            {
                                Tuesday.add(e);
                                chest--;
                            }else if((e.getMuscles() == "Back") && (back > 0))
                            {
                                Tuesday.add(e);
                                back--;
                            }else if((e.getMuscles() == "Shoulders") && (shoulders > 0))
                            {
                                Thursday.add(e);
                                shoulders--;
                            }else if((e.getMuscles() == "Legs") && (legs > 0))
                            {
                                Thursday.add(e);
                                legs--;
                            }else if((e.getMuscles() == "Biceps") && (bic > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                bic--;
                            }else if((e.getMuscles() == "Triceps") && (tric > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                tric--;
                            }else if((e.getMuscles() == "Abs") && (abs > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                abs--;
                            }else if((e.getMuscles() == "All") && (cardio > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                cardio--;
                            }
                         }
                         break;
                    case 3: //Treis meres ths vdomadas
                         chest = 3; back = 3; shoulders = 3; legs = 3; bic = 2; tric = 2; abs = 2; cardio = 2;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                    
                            if((e.getMuscles() == "Chest") && (chest > 0))
                            {
                                Monday.add(e);
                                chest--;
                            }else if((e.getMuscles() == "Back") && (back > 0))
                            {
                                Monday.add(e);
                                back--;
                            }else if((e.getMuscles() == "Shoulders") && (shoulders > 0))
                            {
                                Wednesday.add(e);
                                shoulders--;
                            }else if((e.getMuscles() == "Legs") && (legs > 0))
                            {
                                Wednesday.add(e);
                                legs--;
                            }else if((e.getMuscles() == "Biceps") && (bic > 0))
                            {
                                Friday.add(e);
                                bic--;
                            }else if((e.getMuscles() == "Triceps") && (tric > 0))
                            {
                                Friday.add(e);
                                tric--;
                            }else if((e.getMuscles() == "Abs") && (abs > 0))
                            {
                                Friday.add(e);
                                abs--;
                            }else if((e.getMuscles() == "All") && (cardio > 0))
                            {
                                Monday.add(e);
                                Wednesday.add(e);
                                Friday.add(e);
                                cardio--;
                            }
                         }
                         break;
                    case 4: //Tesseris meres ths vdomadas
                         chest = 3; back = 3; shoulders = 3; legs = 3; bic = 2; tric = 2; abs = 1; cardio = 2;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                    
                            if((e.getMuscles() == "Chest") && (chest > 0))
                            {
                                Monday.add(e);
                                Thursday.add(e);
                                chest--;
                            }else if((e.getMuscles() == "Back") && (back > 0))
                            {
                                Monday.add(e);
                                Friday.add(e);
                                back--;
                            }else if((e.getMuscles() == "Shoulders") && (shoulders > 0))
                            {
                                Tuesday.add(e);
                                shoulders--;
                            }else if((e.getMuscles() == "Legs") && (legs > 0))
                            {
                                Tuesday.add(e);
                                legs--;
                            }else if((e.getMuscles() == "Biceps") && (bic > 0))
                            {
                                Thursday.add(e);
                                bic--;
                            }else if((e.getMuscles() == "Triceps") && (tric > 0))
                            {
                                Friday.add(e);
                                tric--;
                            }else if((e.getMuscles() == "Abs") && (abs > 0))
                            {
                                Thursday.add(e);
                                Friday.add(e);
                                abs--;
                            }else if((e.getMuscles() == "All") && (cardio > 0))
                            {
                                Monday.add(e);
                                Tuesday.add(e);
                                Thursday.add(e);
                                Friday.add(e);
                                cardio--;
                            }
                         }
                         break;
                    case 5: //Pente meres ths vdomadas
                         chest = 3; back = 3; shoulders = 3; legs = 3; bic = 3; tric = 3; abs = 3; cardio = 2;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                    
                            if((e.getMuscles() == "Chest") && (chest > 0))
                            {
                                Monday.add(e);
                                Thursday.add(e);
                                chest--;
                            }else if((e.getMuscles() == "Back") && (back > 0))
                            {
                                Monday.add(e);
                                Friday.add(e);
                                back--;
                            }else if((e.getMuscles() == "Shoulders") && (shoulders > 0))
                            {
                                Tuesday.add(e);
                                Saturday.add(e);
                                shoulders--;
                            }else if((e.getMuscles() == "Legs") && (legs > 0))
                            {
                                Tuesday.add(e);
                                Saturday.add(e);
                                legs--;
                            }else if((e.getMuscles() == "Biceps") && (bic > 0))
                            {
                                Thursday.add(e);
                                bic--;
                            }else if((e.getMuscles() == "Triceps") && (tric > 0))
                            {
                                Friday.add(e);
                                tric--;
                            }else if((e.getMuscles() == "Abs") && (abs > 0))
                            {
                                Saturday.add(e);
                                abs--;
                            }else if((e.getMuscles() == "All") && (cardio > 0))
                            {
                                Monday.add(e);
                                Tuesday.add(e);
                                Thursday.add(e);
                                Friday.add(e);
                                cardio--;
                            }
                         }
                         break;
                    case 6: //Exi meres ths vdomadas
                         chest = 3; back = 3; shoulders = 3; legs = 3; bic = 2; tric = 2; abs = 2; cardio = 1;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                    
                            if((e.getMuscles() == "Chest") && (chest > 0))
                            {
                                Monday.add(e);
                                if(chest > 1)
                                {
                                    Saturday.add(e);
                                }
                                chest--;
                            }else if((e.getMuscles() == "Back") && (back > 0))
                            {
                                Tuesday.add(e);
                                if(back > 1)
                                {
                                    Saturday.add(e);
                                }
                                back--;
                            }else if((e.getMuscles() == "Shoulders") && (shoulders > 0))
                            {
                                Wednesday.add(e);
                                if(shoulders > 1)
                                {
                                    Saturday.add(e);
                                }
                                shoulders--;
                            }else if((e.getMuscles() == "Legs") && (legs > 0))
                            {
                                Thursday.add(e);
                                if(legs > 1)
                                {
                                    Saturday.add(e);
                                }
                                legs--;
                            }else if((e.getMuscles() == "Biceps") && (bic > 0))
                            {
                                Monday.add(e);
                                Thursday.add(e);
                                bic--;
                            }else if((e.getMuscles() == "Triceps") && (tric > 0))
                            {
                                Tuesday.add(e);
                                Friday.add(e);
                                tric--;
                            }else if((e.getMuscles() == "Abs") && (abs > 0))
                            {
                                Wednesday.add(e);
                                Saturday.add(e);
                                abs--;
                            }else if((e.getMuscles() == "All") && (cardio > 0))
                            {
                                Monday.add(e); Tuesday.add(e); Wednesday.add(e); Thursday.add(e); Friday.add(e);
                                cardio--;
                            }
                         }
                         break;
                }
                break;
            case 3: //Flexibility
                switch(days) //Switch poy kathorizei tis meres gymnastikhs vash ths epiloghs
                {
                    case 1: //Mia mera ths vdomadas
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Wednesday.add(e);
                                flex--;
                            }
                         }
                         break;
                    case 2: //Dyo meres ths vdomadas
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                flex--;
                            }
                         }
                         break;
                    case 3: //Treis meres ths vdomadas
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Monday.add(e);
                                Friday.add(e);
                                flex--;
                            }
                         }
                         Collections.shuffle(ExerciseList);
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Wednesday.add(e);
                                flex--;
                            }
                         }
                         break;
                    case 4: //Tesseris meres ths vdomadas
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Monday.add(e);
                                Friday.add(e);
                                flex--;
                            }
                         }
                         Collections.shuffle(ExerciseList);
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                flex--;
                            }
                         }
                         break;
                    case 5: //Pente meres ths vdomadas
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Monday.add(e);
                                Friday.add(e);
                                flex--;
                            }
                         }
                         Collections.shuffle(ExerciseList);
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                flex--;
                            }
                         }
                         Collections.shuffle(ExerciseList);
                         flex = 4;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Saturday.add(e);
                                flex--;
                            }
                         }
                         break;
                    case 6: //Exi meres ths vdomadas
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Monday.add(e);
                                Friday.add(e);
                                flex--;
                            }
                         }
                         Collections.shuffle(ExerciseList);
                         flex = 6;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Tuesday.add(e);
                                Thursday.add(e);
                                flex--;
                            }
                         }
                         Collections.shuffle(ExerciseList);
                         flex = 4;
                         for(i=0; i < ExerciseList.size(); i++)
                         {
                            e = ExerciseList.get(i);
                            
                            if((e.getType() == "Flexibility") && (flex > 0))
                            {
                                Wednesday.add(e);
                                Saturday.add(e);
                                flex--;
                            }
                         }
                         break;
                }
                break;
        }
        
        return;
    }
    
    private void Show_Plan(int type) //Methodos poy emfanizei to programma kai to tropo ekteleshs toy vasei toy typoy gymnastikhs poy exei epilexei o xrhsths.
    {
        int i;
        Exercise e;
        System.out.println("First of all some general information for the excution part of your plan: ");
        switch(type)
        {
            case 1:
                System.out.println("Since you selected for the Weight loss plan you must do for each exercise 3 sets of 20 repetitions.");
                System.out.println("Also for cardio exercises that do not have a distance goal you have to do at least 20 minutes for each.");
                System.out.println("Finally you must have breaks between each set and exercise that feel comfortable to you(Usually more than 1 minute but not more than 2 or 3).");
                break;
            case 2:
                System.out.println("Since you selected for the Strength plan you must do for each exercise 4 sets of 10 repetitions.");
                System.out.println("Also for cardio exercises that do not have a distance goal you have to do at least 10 minutes for each.");
                System.out.println("Finally you must have breaks between each set and exercise of around 45 secs to 1 minute.");
                break;
            case 3:
                System.out.println("Since you selected for the Flexibility plan you must exercise for 60 to 90 minutes each day breaking down time evenly to each exercise.");
                System.out.println("Finally you must have breaks between each exercise of around 2 minutes.");
                break;
        }
        System.out.println("The generated exercise plan is the following:");
        System.out.print("Monday: ");
        if(Monday.isEmpty())
        {
            System.out.println("No exercise");
        }else
        {
            for (i = 0; i < Monday.size(); i++)
            {
                e = Monday.get(i);
                
                System.out.print(e.getExerName() + " ,");
            }
            System.out.println(".");
        }
        
        System.out.print("Tuesday: ");
        
        if(Tuesday.isEmpty())
        {
            System.out.println("No exercise");
        }else
        {
            for (i = 0; i < Tuesday.size(); i++)
            {
                e = Tuesday.get(i);
                
                System.out.print(e.getExerName() + " ,");
            }
            System.out.println(".");
        }
        
        System.out.print("Wednesday: ");
        
        if(Wednesday.isEmpty())
        {
            System.out.println("No exercise");
        }else
        {
            for (i = 0; i < Wednesday.size(); i++)
            {
                e = Wednesday.get(i);
                
                System.out.print(e.getExerName() + " ,");
            }
            System.out.println(".");
        }
        
        System.out.print("Thursday: ");
        
        if(Thursday.isEmpty())
        {
            System.out.println("No exercise");
        }else
        {
            for (i = 0; i < Thursday.size(); i++)
            {
                e = Thursday.get(i);
                
                System.out.print(e.getExerName() + " ,");
            }
            System.out.println(".");
        }
        
        System.out.print("Friday: ");
        
        if(Friday.isEmpty())
        {
            System.out.println("No exercise");
        }else
        {
            for (i = 0; i < Friday.size(); i++)
            {
                e = Friday.get(i);
                
                System.out.print(e.getExerName() + " ,");
            }
            System.out.println(".");
        }
        
        System.out.print("Saturday: ");
        
        if(Saturday.isEmpty())
        {
            System.out.println("No exercise");
        }else
        {
            for (i = 0; i < Saturday.size(); i++)
            {
                e = Saturday.get(i);
                
                System.out.print(e.getExerName() + " ,");
            }
            System.out.println(".");
        }
        
        System.out.println("Synday: Remains always free, so you can rest and also it will be accompanied by a free day in the food plan where you can eat whatever you like.");
        
        return;
    }
    
    private void Make_changes() //methodos poy allazei dyo meres vasei epiloghs xrhsth.
    {
        System.out.println("Do you want to make any changes to the plan that was made?(Answer with 'y' for to make a change or 'n' to not)");
        
        Scanner input = new Scanner(System.in);
        
        String choice = input.nextLine();
        
        String day;
        
        if((choice == "y") || (choice == "yes") || (choice == "Y") || (choice == "YES"))
        {
            System.out.println("Please choose the day you want to change.");
            
            day = input.nextLine();
            
            System.out.println("Please choose the new day to change to.");
            
            choice = input.nextLine();
            
            switch(choice) //Switch poy vriskei tis dyo meres poy epelexe o xrhsths kai enallasei ta stoixeia toys.
            {
                case "monday":
                          ArrayList<Exercise> temp1 = new ArrayList<Exercise>(Monday);
                          switch(day)
                          {
                               case "tuesday":
                                        Monday.clear();
                                        Monday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp1);
                                        break;
                               case "wednesday":
                                        Monday.clear();
                                        Monday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp1);
                                        break;
                               case "thursday":
                                        Monday.clear();
                                        Monday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp1);
                                        break;
                               case "friday":
                                        Monday.clear();
                                        Monday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp1);
                                        break;
                               case "saturday":
                                        Monday.clear();
                                        Monday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp1);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "tuesday":
                          ArrayList<Exercise> temp2 = new ArrayList<Exercise>(Tuesday); 
                          switch(day)
                          {
                               case "monday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp2);
                                        break;
                               case "wednesday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp2);
                                        break;
                               case "thursday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp2);
                                        break;
                               case "friday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp2);
                                        break;
                               case "saturday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp2);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "wednesday":
                          ArrayList<Exercise> temp3 = new ArrayList<Exercise>(Wednesday);
                          switch(day)
                          {
                               case "monday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp3);
                                        break;
                               case "tuesday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp3);
                                        break;
                               case "thursday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp3);
                                        break;
                               case "friday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp3);
                                        break;
                               case "saturday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp3);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "thursday":
                          ArrayList<Exercise> temp4 = new ArrayList<Exercise>(Thursday);
                          switch(day)
                          {
                               case "monday":
                                        Thursday.clear();
                                        Thursday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp4);
                                        break;
                               case "tuesday":
                                        Thursday.clear();
                                        Thursday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp4);
                                        break;
                               case "wednesday":
                                        Thursday.clear();
                                        Thursday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp4);
                                        break;
                               case "friday":
                                        Thursday.clear();
                                        Thursday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp4);
                                        break;
                               case "saturday":
                                        Thursday.clear();
                                        Thursday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp4);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "friday":
                          ArrayList<Exercise> temp5 = new ArrayList<Exercise>(Friday);
                          switch(day)
                          {
                               case "monday":
                                        Friday.clear();
                                        Friday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp5);
                                        break;
                               case "tuesday":
                                        Friday.clear();
                                        Friday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp5);
                                        break;
                               case "wednesday":
                                        Friday.clear();
                                        Friday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp5);
                                        break;
                               case "thursday":
                                        Saturday.clear();
                                        Saturday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp5);
                                        break;
                               case "saturday":
                                        Friday.clear();
                                        Friday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp5);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "saturday":
                          ArrayList<Exercise> temp6 = new ArrayList<Exercise>(Saturday);
                          switch(day)
                          {
                               case "monday":
                                        Saturday.clear();
                                        Saturday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp6);
                                        break;
                               case "tuesday":
                                        Saturday.clear();
                                        Saturday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp6);
                                        break;
                               case "wednesday":
                                        Saturday.clear();
                                        Saturday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp6);
                                        break;
                               case "thursday":
                                        Saturday.clear();
                                        Saturday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp6);
                                        break;
                               case "friday":
                                        Saturday.clear();
                                        Saturday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp6);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                default:
                          System.out.println("No match for the day you chose to change.");
            }
        }else
        {
            System.out.println("You selected to make no changes an so the plan will be saved to your profile.");
            return;
        }
        
        return;
    }
    
    private void Save_plan(User_profile u) //Methodos poy apothkeyei to programma sto profile toy xrhsth
    {
        u.setExMonday(Monday);
        u.setExTuesday(Tuesday);
        u.setExWednesday(Wednesday);
        u.setExThursday(Thursday);
        u.setExFriday(Friday);
        u.setExSaturday(Saturday);
        
        System.out.println("The plan was saved to your profile.");
        return;
    }
}