defmodule Solution do
  @spec min_set_size(arr :: [integer]) :: integer
  def min_set_size(arr) do
    counts = arr
        |> Enum.reduce(%{}, fn item, counts -> Map.put(counts, item, Map.get(counts, item, 0) + 1) end)
    idxs = counts
        |> Map.keys()
        |> Enum.sort(&!(Map.get(counts, &1) < Map.get(counts, &2)))
    total_count = length(arr)
    {countv, dcountv} = idxs
        |> Enum.reduce({0, 0}, fn idx, {countv, dcountv} -> if total_count <= countv * 2, do: {countv, dcountv}, else: {countv + Map.get(counts, idx), dcountv+1} end)
    dcountv
  end
end
