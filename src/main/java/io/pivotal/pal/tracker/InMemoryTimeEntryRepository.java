package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> timeEntriesMap = new HashMap<>();
    private Long timeEntrySequence = 0l;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntrySequence++;

        if (timeEntry.getId() == null) {
            timeEntry.setId(timeEntrySequence);
        }

        timeEntriesMap.put(timeEntry.getId(), timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntriesMap.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> valueList = new ArrayList<>(timeEntriesMap.values());
        return valueList;
    }

    @Override
    public void delete(long id) {
        timeEntriesMap.remove(id);
    }

    @Override
    public TimeEntry update(long l, TimeEntry timeEntry) {
        TimeEntry existingTimeEntry = timeEntriesMap.get(l);
        if (existingTimeEntry != null) {
            existingTimeEntry.setDate(timeEntry.getDate());
            existingTimeEntry.setHours(timeEntry.getHours());
            existingTimeEntry.setUserId(timeEntry.getUserId());
            existingTimeEntry.setProjectId(timeEntry.getProjectId());
        }
        return existingTimeEntry;
    }
}
