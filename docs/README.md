# User Guide

## Welcome to Adi's Duke Project

Hi! Welcome to Adi's **Duke** project :smiley:. This is an automated **Task Scheduler** that can change your life forever (hopefully...:neutral_face:).

## Features 

### Feature 1

Add task (Todo, Event, Deadline) :notebook:

### Feature 2

List tasks

### Feature 3

Delete task

### Feature 4

Mark task as done

### Feature 5

Find task

### Feature 6

Storage of past data

## Usage

### Create a todo items

Format: 

`todo [task_description]`

Example of usage: 

`todo eat`

Expected outcome:

 Got it. I've added this task:
 
   [T][not done] eat
 
 Now you have 3 tasks in the list.

### Create an event items

Format: 

`event [task_description] /at[event_time]`

Example of usage: 

`event meet Obama /at 2020-12-12`

Expected outcome:

 Got it. I've added this task:
 
   [E][not done] meet Obama  (at: Dec 12 2020)
   
 Now you have 4 tasks in the list.


### Create an deadline items

Format:

`deadline [task_description] /by[deadline_time]`

Example of usage: 

`deadline approve internship /by 2020-12-12`

Expected outcome:

 Got it. I've added this task:
 
   [D][not done] approve internship  (by: Dec 12 2020)
   
 Now you have 5 tasks in the list.

### Display list :page_facing_up:

Format:

`list`

Example of usage: 

`list`

Expected outcome:

 Here are the tasks in your list:
 
 1.[T][not done] eat
 
 2.[E][not done] sleep  (at: Feb 23 2020)
 
 3.[E][not done] meet Obama  (at: Dec 12 2020)
 
 4.[D][not done] approve internship  (by: Dec 12 2020)

### Mark task as done :heavy_check_mark:

Format:

`done [task_number]`

Example of usage: 

`done 1`

Expected outcome:

 Nice! I've marked this task as done:
 
 [done] eat

### Delete a task :no_entry_sign:

Format:

`delete [task_number]`

Example of usage: 

`delete 1`

Expected outcome:

 Noted. I've removed this task:
 
   [T][done] eat
 
 Now you have 3 tasks in the list.
`

### Find task based on description :mag:

Format:

`find [keyword]`

Example of usage: 

`find internship`

Expected outcome:

 Here are the matching tasks in your list:

1.[D][not done] approve internship  (by: Dec 12 2020)

### Many more to come :smiley:


## Contributors

This is a solo project TT.

## Contact Us

- **Bug reports**, **Suggestions** : Email to [this email](adinatatan99@gmail.com) of you have any querries or suggestions.
- **Contributing** : We welcome pull requests. Simply fork [this repository](https://github.com/adinata15/ip)
