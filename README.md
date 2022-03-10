# Shedlock

ShedLock makes sure that your scheduled tasks are executed at most once at the same time. If a task is being executed on one service instance/node, it acquires a lock which prevents execution of the same task from another node (or thread). Please note, that if one task is already being executed on one node, execution on other nodes does not wait, it is simply skipped.

ShedLock is a time-based lock and ShedLock assumes that clocks on the nodes are synchronized. ShedLock is designed to be used in situations where you have scheduled tasks that are not ready to be executed in parallel, but can be safely executed repeatedly.


**Warning**
Do not manually delete lock row from the DB table. ShedLock has an in-memory cache of existing lock rows so the row will NOT be automatically recreated until application restart. If you need to, you can edit the row/document, risking only that multiple locks will be held

The program contains a simple use of Shedlock with an Spring Boot Application.
