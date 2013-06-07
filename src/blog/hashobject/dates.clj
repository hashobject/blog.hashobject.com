(ns blog.hashobject.dates
  (:require [clj-time.core :as clj-time]
            [clj-time.format :as clj-time-format]))


(defn reformat-datestr [date-str initial-format final-format]
  (let [date (clj-time-format/parse (clj-time-format/formatter initial-format) date-str)]
        (clj-time-format/unparse (clj-time-format/formatter final-format) date)))


