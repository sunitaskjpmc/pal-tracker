package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(Long id);

    List<TimeEntry> list();

    void delete(Long id);

    TimeEntry update(Long l, TimeEntry timeEntry);
}
