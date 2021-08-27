defmodule Solution do
  @spec find_length(nums1 :: [integer], nums2 :: [integer]) :: integer
  def find_length(nums1, nums2) do
    max(slide(nums1, nums2), slide(nums2, nums1))
  end

  def slide(nums1, nums2, maxv \\ 0)
  def slide(_, [], maxv), do: maxv
  def slide(nums1, nums2 = [_ | tail2], maxv) do
    slide(nums1, tail2, max(maxv, count_length(nums1, nums2)))
  end

  @spec count_length([integer], [integer], integer, integer) :: integer
  def count_length(nums1, nums2, maxv \\ 0, acc \\ 0)
  def count_length([], _, maxv, _), do: maxv
  def count_length(_, [], maxv, _), do: maxv
  def count_length([num1 | tail1], [num2 | tail2], maxv, acc) do
    {nmaxv, nacc} = if num1 == num2 do
        {max(maxv, acc + 1), acc + 1}
      else
        {maxv, 0}
      end
    count_length(tail1, tail2, nmaxv, nacc)
  end
end
