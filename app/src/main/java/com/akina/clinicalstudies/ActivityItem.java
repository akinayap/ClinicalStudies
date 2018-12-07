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
        m_endTime = m_startTime;
        m_endTime.add(Calendar.MONTH, 2);

        m_title = title;
        m_subtext = subtext;
        m_contactName = contactName;
        m_contactNumber = contactNumber;
    }


}
