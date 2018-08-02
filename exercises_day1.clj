(defn add-milk []
    (grab :cup)
    (scoop :milk)
    (add-to-bowl)
    (release))

(defn add-egg []
    (grab :egg)
    (squeeze)
    (add-to-bowl))

(defn add-flour []
    (grab :cup)
    (scoop :flour)
    (add-to-bowl)
    (release))


(defn add-sugar []
    (grab :cup)
    (scoop :sugar)
    (add-to-bowl)
    (release))

(defn add-butter []
    (grab :butter))

(defn bake-cake-1st []
    (add-flour)
    (add-flour)
    (add-egg)
    (add-egg)
    (add-milk)
    (mix)
    (pour-into-pan)
    (bake-pan 25)
    (cool-pan))

(defn add [ingredient]
    (cond
        (= ingredient :egg)
        (add-egg)
        (= ingredient :milk)
        (add-milk)
        (= ingredient :flour)
        (add-flour)
        (= ingredient :butter)
        (add-butter)
        (= ingredient :sugar)
        (add-sugar)
        :else
        (println "Ingrediente desconhecido:" ingredient)))

(defn bake-cake []
    (add :flour)
    (add :flour)
    (add :egg)
    (add :egg)
    (add :milk)
    (mix)
    (pour-into-pan)
    (bake-pan 25)
    (cool-pan))

;Exercise 5
(defn scooped? [ingredient]
    (cond 
          (= ingredient :milk)
          true
          (= ingredient :flour)
          true
          (= ingredient :sugar)
          true
          :else
          false))

;Exercise 6
(defn squeezed? [ingredient]
    (cond
        (= ingredient :egg)
        true
        :else
        false))

(defn squeezed? [ingredient]
    (= ingredient :egg))
    
;Exercise 7
(defn simple? [ingredient]
    (= ingredient :butter))

;Exercise 8
(defn add-simple [ingredient]
    (if (simple? ingredient)
        (do
            (grab ingredient)
            (add-to-bowl))
        (do
            (println "Ingredient" ingredient "not simple. Nothing added.")
            :error)))

(defn add-squeezed [ingredient]
    (if (squeezed? ingredient)
        (do
            (grab ingredient)
            (squeeze)
            (add-to-bowl))
        (do
            (println "Nothing added. Ingredient" ingredient "not squeezable")
            :error)))

(defn add-scooped [ingredient]
    (if (scooped? ingredient)
        (do
            (grab :cup)
            (scoop ingredient)
            (add-to-bowl)
            (release))
        (do
            (println "Nothind added. Ingredient not scoopable: " ingredient)
            :error)))

;Exercise 9
(defn add [ingredient]
    (cond
        (squeezed? ingredient)
        (add-squeezed ingredient)
        (scooped? ingredient)
        (add-scooped ingredient)
        (simple? ingredient)
        (add-simple ingredient)
        :else
        (do
            (println "Unknown ingredient" ingredient)
            :error)))

(defn add-eggs [neggs]
  (dotimes [e neggs]
    (add-egg)))

(defn add-flour-cups [ncups]
    (dotimes [e ncups]
        (add-flour))
    :ok)

(defn add-sugar-cups [ncups]
    (dotimes [e ncups]
        (add-sugar))
    :ok)

(defn add-milk-cups [ncups]
    (dotimes [e ncups]
        (add-milk))
    :ok)

(defn add-butters [nbutter]
    (dotimes [e nbutter]
        (add-butter))
    :ok)

;Exercise 10 - Rewrite bake-cake

(defn bake-cake-new []
    (add-flour-cups 2)
    (add-eggs 2)
    (add-milk-cups 1)
    (mix)
    (pour-into-pan)
    (bake-pan 25)
    (cool-pan))

(defn bake-cake []
    (add :flour)
    (add :flour)
    (add :egg)
    (add :egg)
    (add :milk)
    (mix)
    (pour-into-pan)
    (bake-pan 25)
    (cool-pan))

;Exercise 11
(defn add-simple 
    ([ingredient amount] 
            (if (simple? ingredient)
                (do
                    (dotimes [i amount]
                        (grab ingredient)
                        (add-to-bowl))
                    :ok)
                (do
                    (println "Ingredient" ingredient "not simple. Nothing added.")
                    :error)))
    ([ingredient]
        (add-simple ingredient 1)))

(defn add-squeezed 
    ([ingredient amount] 
            (if (squeezed? ingredient)
                (do
                    (dotimes [i amount]
                        (grab ingredient)
                        (squeeze)
                        (add-to-bowl))
                    :ok)
                (do
                    (println "Ingredient" ingredient "not squeezable. Nothing added.")
                    :error)))
    ([ingredient]
        (add-squeezed ingredient 1)))

(defn add-scooped 
    ([ingredient amount] 
            (if (scooped? ingredient)
                (do
                    (dotimes [i amount]
                        (grab :cup)
                        (scoop ingredient)
                        (add-to-bowl)
                        (release))
                    :ok)
                (do
                    (println "Ingredient" ingredient "not scoopable. Nothing added.")
                    :error)))
    ([ingredient]
        (add-scooped ingredient 1)))

(defn add
    ([ingredient amount]
        (cond 
            (squeezed? ingredient)
            (add-squeezed ingredient amount)
            (scooped? ingredient)
            (add-scooped ingredient amount)
            (simple? ingredient)
            (add-simple ingredient amount)
            :else
            (do
                (println "Unknown ingredient" ingredient)
                :error)))
    ([ingredient]
        (add ingredient 1)))

;Exercise 12
(defn bake-cake []
    (add :flour 2)
    (add :egg 2)
    (add :milk)
    (add :sugar)
    (mix)
    (pour-into-pan)
    (bake-pan 25)
    (cool-pan))

;Exercise 13
(defn bake-cookie []
    (add :egg)
    (add :flour)
    (add :butter)
    (add :sugar)
    (mix)
    (pour-into-pan)
    (bake-pan 30)
    (cool-pan))