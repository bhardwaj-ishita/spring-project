package com.noobForce.klasa.service;


import com.noobForce.klasa.model.Announcement;
import com.noobForce.klasa.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AnnouncementService
{
    private final AnnouncementRepository announcementRepository;
    
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository)
    {
        this.announcementRepository = announcementRepository;
    }
    
    public Announcement addAnnouncement(Announcement announcement)
    {
        return announcementRepository.save(announcement);
    }
    
    public void deleteAnnouncement()
    {
        announcementRepository.deleteAll();
    }
    
    public List<Announcement> getAllAnnouncements()
    {
        deleteAnnouncement();
        String[] profnames = new String[3];
        String[] announce = new String[15];
        LocalDate[] dates = new LocalDate[15];
        LocalTime[] times = new LocalTime[15];
        
        int[] d = new int[15];
        Random r = new Random();
        
        for (int i = 0; i < 15; i++)
            d[i] = Math.abs(r.nextInt() % 27) + 1;
        
        Arrays.sort(d);
        
        for (int i = 0; i < 15; i++) {
            dates[i] = LocalDate.of(2021, 6, d[i]);
            times[i] = LocalTime.of(Math.abs(r.nextInt() % 12) + 1, Math.abs(r.nextInt() % 60));
        }
        
        
        profnames[0] = "Shweta Sharma";
        profnames[1] = "Jayati Jain";
        profnames[2] = "Madhu Sharma";
        
        announce[0] = "Cancelled class tomorrow\n" +
                "Dear Students\n" +
                "We won’t be meeting tomorrow. The next class will be on June 17th.\n" +
                "Shweta";
        
        announce[1] = "There will be a quiz on Friday from 11-12. " +
                "This will be the first of the 3 quizzes which are supposed to be of 40% weightage.";//\n";
//                "\n" +
//                "The question paper will be posted on Google Classroom at 11am on Friday. There will be a late penalty of 1 mark deducted for every minute by which the submission is late. The deadline is 12noon.";
        
        announce[2] = "Dear Students\n" +
                "\n" +
                "Some students have changed their branch, so they moved from Section B to A, for such students, follow the same group no. in Section A as well";
                // \n" +
                // "\n";

        announce[3] = "Announcement: The extra credit policy (announced in class on June 4th) will also cover corrections of mistakes in lecture recordings. The date of the lecture and the minutes where the mistake is made should be emailed to me, or posted in Google Classroom.";
        
        announce[4] = "Hi everyone,\n" +
                "\n" +
                "This is to inform you that Lab 1 plag cases have been reported to the Academic Section and we are in the process of reporting Lab 2 plag cases now. Surprisingly, there are lot of students involved in plagiarism activities.";// +
                // "This is a STRICT WARNING to all of you to not to indulge in such activities.";// +
                // "\n" +
                // "Note: We believe that you know the harsh consequences of being involved in plagiarism.\n" +
                // "Please read the IIITD plag policy again on the website.";
        
        announce[5] = "For Students of SEC-A,\n" +
                "\n" +
                "\n" +
                "As per the poll conducted, we have decided to conduct weekly quiz on Monday 7 PM.\n" +
                "As due to time constraint we can not conduct the quiz tomorrow, so for this week quiz will be on Wednesday (23 June 2021).";// +
                // "Details for quiz1 are as follows:-";// +
                // "Timings - 7 PM\n" +
                // "Duration- 15-20 Mins\n" +
                // "Type- MCQ Based \n" +
                // "Syllabus- First 4 lectures\n" +
                // "NOTE:- The quizzes altogether will be counted in 6% participation component.";
        
        announce[6] = "Section B, Group 2 students, the previous link isnt working so kindly join this link\n" +
                "https://meet.google.com/ptd-bzjo-skw\n" +
                "\n" +
                "(invite has been mailed to you)";
        
        announce[7] = "Just for clarification\n" +
                "\n" +
                "Only correct submissions will be counted in 5℅ bonus, for weekly LABs.";
        
        announce[8] = "Dear all,\n" +
                "\n" +
                "\n" +
                "Lab will be released in while and you will get sufficient for it. After that questions will be available in practice session.";
        
        announce[9] = "Hi everyone,\n" +
                "\n" +
                "There is a slight change in the Tutorial, Lab and one to one TA- student mapping. Please go through the sheets posted, before joining your respective groups.";
        
        announce[10] = "Hi all,\n" +
                "\n" +
                "\n" +
                "PFA the program which uses Reader class for Input. A sample program of Linear Search has been implemented.";// +
                // "\n" +
                // "\n" +
                // "Some important points about Reader Class:\n" +
                // "1. Reader class is faster than Scanner class.\n" +
                // "2. One has to take care of the position of the cursor when using Scanner class. If not done so, there is a chance of faulty input.\n" +
                // "There are no so such concerns regarding Reader class and it is pretty straightforward to use.";
        
        announce[11] = "Lab 1 : Rubric\n" +
                "Theoretical calculation of Current (through RL & RAB), Thevenin's Voltage(VTH), Norton's current(IN), Thevenin’s Resistance(RTH) across AG and AB : 2 marks\n" +
                "TinkerCAD link (Thevenin's & Norton's) : 2 marks";/// +
                // "Screenshot of TinkerCAD workspace (Thevenin’s and Norton’s) : 1 mark";
        
        announce[12] = "Quiz_1_Update:\n" +
                "\n" +
                "Dear All,\n" +
                "\n" +
                "I hope you have received the calendar invite with Meet link for Quiz_1.";// +
                // "If you have not received yet please let me know.(First Check Google Calendar)\n" +
                // "\n" +
                // "Submission over classroom.";
        
        announce[13] = "Hello all, \n" +
                "You are supposed to upload the solutions of the tutorial sheet by the due date as mentioned in the classroom. We will post the solution after the due date.";
        
        announce[14] = "One hour was extended by one faculty member because a lot of her students were having uploading issues. I could not receive the decision in time, so could not extend your deadline in time.";
        // So we will take into consideration this situation during evaluation and mark accordingly. So relax about that.";
        
        int start = Math.abs(r.nextInt() % 15);
        for (int i = 0; i < 15; i++) {
            int x = Math.abs(r.nextInt() % 3);
            Announcement an = new Announcement(profnames[x], announce[(start++) % 15], dates[i], times[i]);
            addAnnouncement(an);
        }
        return announcementRepository.findAll();
    }
    
    public List<Announcement> getAllAnnouncementsByDate(int date)
    {
        getAllAnnouncements();
        return announcementRepository.findByDate(LocalDate.of(2021, 06, date));
    }
}
