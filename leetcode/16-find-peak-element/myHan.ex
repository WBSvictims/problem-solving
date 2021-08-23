defmodule Solution do
  @spec search(%{integer => integer}, integer, integer) :: integer
  def search(nums, front, back) when front + 1 < back do
    mid = div(front + back, 2)
    prv = Map.get(nums, mid-1)
    cur = Map.get(nums, mid)
    nxt = Map.get(nums, mid+1)
    {nfront, nback} = cond do
      prv < cur && cur < nxt -> {mid, back}
      nxt < cur && prv < cur -> {mid, mid+1}
      true -> {front, mid}
    end
    search(nums, nfront, nback)
  end

  def search(_, front, _), do: front

  @spec find_peak_element(nums :: [integer]) :: integer
  def find_peak_element(nums) do
    mnums = nums
      |> Enum.zip(0 .. (length(nums) - 1))
      |> Enum.reduce(%{}, fn {v, k}, acc -> Map.put_new(acc, k, v) end)

    search(mnums, 0, length(nums))
  end
end
