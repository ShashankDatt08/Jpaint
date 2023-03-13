# privatejpaint
JPaint Application
Student: Shashank Datt HL 
University: DePaul University
Intake: Winter 2023
Subject: SE 450 Object Oriented Software Development 
Professor: Jeffrey Sharpe  

#Sprint 1
- Draw a filled-in Rectangle
  Click and drag while in Draw mode :
    Afilled-in Rectangle will display when you release the mouse. 
    The size will resemble based on mouse pressed and mouse released event.
    The filled-in Rectangle will display when after the mouse is released and wont displat while clicking and dragging
- Undo:
    The last drawn Rectangle will be removed when the undo button is used.
- Redo:
     The last Removed Rectangle will be restored back when the redo button is used.

#Sprint 2
- Draw Rectangles, Ellipses, and Triangles
   Rectangles, Ellipses, and Triangles will display when you release the mouse.
- Draw shapes with various colors
   Rectangles, Ellipses, and Triangles will display with various colors when you release the mouse.
- Draw shapes with various shading types
   Rectangles, Ellipses, and Triangles will display with various shading types when you release the mouse.
- Select a shape. 
   The shapes will be selected as you click the shape or drag near any shape
- Move a shape.
   The Selected shapes will be moved according to the mouse and will display once you release the mouse.
- Undo:
    The last drawn or moved shapes will be removed when the undo button is used.
- Redo:
     The last Removed or moved will be restored back when the redo button is used.
     
#Sprint 3
 Copy:
  Adds selected shapes to the “clipboard”
 Paste:
  Pastes the copied shape with (200,70) so that it will be visible and wont overlap with original shape.
 Delete:
  Deletes the selected shape with undo and redo implemented for this functionality.
  
#Sprint 4
  Group Command:
    Clicking this button will cause all Selected shapes to operate as a group.
    Shapes grouped together should be operated on as if they were one shape.
    To select a grouped shape, any part of the invisible bounding box around the shapes in the group can be selected.
  Ungroup Command:
   Any selected shapes that are grouped shapes will no longer be grouped.
    If a selected group is comprised of one or more groups, only the outer-most group is ungrouped
  Undo
    Undo functionality implemented for group and ungroup
  Redo Group and Ungroup
    Redo functionality implemented for group and ungroup
    
Design Pattern:
  Observer Patter : Shaper is implementing Observer pattern 
  Abstract factory Pattern: IShape is implementing Abstract factory pattern
  Singleton Pattern: ShapeColorMap implements singleton pattern
  Stratergy Pattern: IShapeShading type class implements Stratergy pattern
  Command Pattern : DrawShape, SelectShape, MoveShape, CopyShape, PasteShape, GroupCommand, UngroupCommand, RotateShape, flipShape implements CommandPatter.
     
Github Repo Link:
https://github.com/ShashankDatt08/privatejpaint
