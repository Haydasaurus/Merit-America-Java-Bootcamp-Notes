# Module 1 Capstone

## Setting students up for success

- Release the requirements to students either the night before or the morning of.
- Encourage them to spend at least one hour planning and identifying the *nouns* and *verbs* of the vending machine.
- Implement the functionality of the vending machine in vertical slices. Focus on functionality instead of coming up with all of the necessary classes up front.
- Emphasize *pair programming*.
    - The purpose of this project is to help you solidify your understanding of how objects interact.
    - Don't split up and try to delegate work to each other. Opportunities for that exist in later capstones.
    - Talk out the code. Employers want to understand the collaboration capabilities of students. Silent students that don't ask questions are easy to spot, so are ones who understand logic but struggle to articulate it.

## Designing the solution

- After an hour of planning, offer the students the opportunity to come back into the room and discuss a design that has worked in the past.
- Below is an example of a *potential solution*.
  - **Note**: it may not be accurate to all requirements.

![Solution](../resources/big-picture.png)

- Students most often feel overwhelmed. Emphasize that this is a 4-day assignment built incrementally.

**Features**

1. Read file in and convert to inventory
2. Display inventory contents
3. Support vending machine purchase
4. Handle change back from the vending machine
5. Print audit file out
6. Handle exceptional cases


## Common mistakes and struggles students have

Some of these are mistakes to prevent during coding, but some of them also make for good feedback during the code review of the capstone:

- Converting a line from the input file into the inventory object
- Using stdio inside any class other than the main menu or the CLI
- Re-reading the file each time the inventory of the vending machine is accessed
- Having missing try/catch blocks or empty catch blocks
- Hardcoded file paths in the code
- Implementing File I/O from the vending machine
- Using magic numbers when parsing the file
- After the transaction, the balance of the machine is not emptied and carries over to the next transaction
- Multiple vending machine instances get created
- Creating stack overflow conditions when students try to create a "goto" approach