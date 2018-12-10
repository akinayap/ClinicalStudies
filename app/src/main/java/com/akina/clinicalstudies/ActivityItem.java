package com.akina.clinicalstudies;

import java.util.Calendar;

class ActivityItem {

    enum Status {
     ACCEPTED,
     PENDING,
     COMPLETE
    }
    Status m_status;
    int m_progress;
    Calendar m_startTime, m_endTime;
    String m_title, m_subtext, m_contactName, m_contactNumber;

    ActivityItem(String title, String subtext, String contactName, String contactNumber)
    {
        m_status = Status.PENDING;
        m_progress = 0;
        m_startTime = Calendar.getInstance();
        m_endTime = Calendar.getInstance();
        m_endTime.add(Calendar.MONTH, 4);

        m_title = title;
        m_subtext = subtext;
        m_contactName = contactName;
        m_contactNumber = contactNumber;
    }

    void setStatus(Status s)
    {
        m_status = s;
    }

    void setProgress(int percentage)
    {
        m_progress = percentage;
    }

    void setEndTimeUsingDuration(int year, int month, int day)
    {
        m_endTime.setTimeInMillis(m_startTime.getTimeInMillis());
        m_endTime.add(Calendar.YEAR, year);
        m_endTime.add(Calendar.MONTH, month);
        m_endTime.add(Calendar.DAY_OF_YEAR, day);
    }

    void setEndTime(int year, int month, int day)
    {
        m_endTime.setTimeInMillis(m_startTime.getTimeInMillis());
        m_endTime.set(year, month, day);
    }

    void setEndTime(Calendar c)
    {
        m_endTime = c;
    }


}
