defmodule Solution do
	@doc """
	Find a representative of the group

	## Examples

	    iex> Solution.find(%{1 => 2, 2 => 3, 3 => 3}, 1)
	    {%{1 => 3, 2 => 3, 3 => 3}, 3}
	"""
	def find(disjoint_set, u) do
		v = Map.get(disjoint_set, u)
		cond do
			u == v -> {disjoint_set, u}
			true   ->
				{disjoint_set, g} = find(disjoint_set, v)
				{Map.put(disjoint_set, u, g), g}
		end
	end

	def union(disjoint_set, u, v) do
		Map.put(disjoint_set, u, v)
	end

	@spec find_redundant_connection(edges :: [[integer]]) :: [integer]
	def find_redundant_connection(edges) do
		disjoint_set = 1..length(edges) |> Enum.reduce(%{}, fn u, acc -> Map.put(acc, u, u) end)

    	{_, ans} = Enum.reduce(edges, {disjoint_set, nil}, fn
    		[u, v], {disjoint_set, nil} ->
    			{disjoint_set, gu} = find(disjoint_set, u)
    			{disjoint_set, gv} = find(disjoint_set, v)
    			cond do
    				gu == gv -> {disjoint_set, [u, v]}
    				true -> {union(disjoint_set, gu, gv), nil}
    			end
    		_, ret          -> ret
    	end)
    	ans
    end
end
