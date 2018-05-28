(use '[leiningen.exec :only (deps)])

(deps '[[riemann-clojure-client "0.4.5"]])

(require '[riemann.client :refer :all])

(with-open [c (tcp-client {:host "0.0.0.0" :port 5555})]
  (let [e {:service "healthcheck" :state "ok"}]
    (send-event c e)
    (let [e1 (first @(query c "service = \"healthcheck\" and state = \"ok\""))
          error-code (if (and (= (:service e) (:service e1)) (= (:state e) (:state e1))) 0 1)]
      (System/exit error-code))))

