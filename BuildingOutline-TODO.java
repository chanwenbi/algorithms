/**
 * Given n buildings, each building is an rectangle located on x-axis,
 * and indicated by (x1, x2, height). Calculate the outline of all buildings.
 * Output them in order.
 *
 * idea:
 * Separate (x1, x2, height) to (x1, height, BUILDING_START), (x2, height, BUILDING_END)
 * Sort all items by x’s ascending order.
 * Swipe the items from left to right, keep a max heap store heights, when meet
 * a BUILDING_START item, insert the height into the heap, when meet a BUILDING_END item,
 * delete the height in the heap.
 * The max height in the heap is height in outline with current x you meet.
 */
public class Solution {

}
