defmodule Solution do
  @spec predict_the_winner(nums :: [integer]) :: boolean
  def predict_the_winner(nums) do
    numm = nums
      |> Enum.with_index()
      |> Enum.map(fn {v, k} -> {k, v} end)
      |> Map.new()
    {{me, opp}, _} = predict(numm, 0, map_size(numm), %{})
    opp <= me
  end

  @doc """
  #Parameters
    numm => map of numbers
    front => leftmost index
    back => rightmost index
    mem => map for memoization
  #Return
    {{best point of begin player, best point of following player}, memoization map}
  """
  def predict(_, front, back, mem) when is_map_key(mem, {front, back}), do: {Map.get(mem, {front, back}), mem}

  def predict(numm, front, front, mem), do: {{0, 0}, mem}

  def predict(numm, front, back, mem) do
    # take left card
    {{fopp, fme}, mem} = predict(numm, front+1, back, mem)
    # take right card
    {{bopp, bme}, mem} = predict(numm, front, back-1, mem)

    # take_front => my best point when I take leftmost card
    take_front = fme + Map.get(numm, front)
    # take_back => my best point when I take wightmost card
    take_back = bme + Map.get(numm, back-1)

    # take better one
    ret = if take_front < take_back do
      {take_back, bopp}
    else
      {take_front, fopp}
    end

    {ret, Map.put(mem, {front, back}, ret)}
  end
end
