/*
Your friend is developing a small image processing program and has asked for your help in implementing MS-Paint's “paint bucket”-like functionality.
 Their program represents images using arrays of characters, with each array value representing a pixel and letters and symbols representing 
 different colors. For example, the following 4x6 matrix represents the letter P in color "#", with background color "." (dot) 

.###.. 
.#..#. 
.###.. 
.#....

Pixel (0,1) color: 'O'

.OOO.. 
.O..#. 
.OOO.. 
.O....


*/
const fillAllPaintingDirections = (painting, x, y, colorToBePainted, newColor, rowSize, columnSize) => {

	if (x < 0 || x >= rowSize || y < 0 || y >= columnSize || painting[x][y] != colorToBePainted) {
	      return false;
	}  
      
	painting[x][y] = newColor;
      
	fillAllPaintingDirections(painting, x, y - 1, colorToBePainted, newColor, rowSize, columnSize);
	fillAllPaintingDirections(painting, x, y + 1, colorToBePainted, newColor, rowSize, columnSize);
	fillAllPaintingDirections(painting, x - 1, y, colorToBePainted, newColor, rowSize, columnSize);
	fillAllPaintingDirections(painting, x + 1, y, colorToBePainted, newColor, rowSize, columnSize);
      
      }
      
      
      const paint = ({ painting, coordinates, newColor, rowSize, columnSize }) => {
	const colorToBePainted = painting[coordinates.x][coordinates.y];
      
	if (colorToBePainted !== newColor) {
	      fillAllPaintingDirections(painting, coordinates.x, coordinates.y, colorToBePainted, newColor, rowSize, columnSize);
      
	};
      }
      
      
      const paintingInfo = {
	      coordinates: {
		      x: 0,
		      y: 1
	      },
	      newColor: '0',
	      rowSize: 4,
	      columnSize: 6,
	      painting: [
		      ['.', '#', '#', '#', '.', '#'],
		      ['.', '#', '.', '.', '#', '.'],
		      ['.', '#', '#', '#', '.', '.'],
		      ['.', '#', '.', '.', '.', '.'],
	      ],
      }
      
      console.log(paintingInfo.painting);
      
      paint(paintingInfo);
      
      console.log('-------------------------');
      console.log(paintingInfo.painting);
      